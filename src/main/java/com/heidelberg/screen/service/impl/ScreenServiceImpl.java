package com.heidelberg.screen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heidelberg.screen.common.MapBeanUtil;
import com.heidelberg.screen.config.HdbConstantConfig;
import com.heidelberg.screen.mapper.*;
import com.heidelberg.screen.model.ConfigData;
import com.heidelberg.screen.model.DataRang;
import com.heidelberg.screen.model.FlowInfo;
import com.heidelberg.screen.model.OrderInfo;
import com.heidelberg.screen.service.ScreenService;
import com.heidelberg.screen.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private ProduceMapper produceMapper;

    @Autowired
    private FlowInfoMapper flowInfoMapper;

    @Autowired
    private ConfigDataMapper configDataMapper;

    @Autowired
    private DataRangMapper dataRangMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HdbConstantConfig hdbConstantConfig;

    String[] order = {"喷码", "印刷", "上光", "覆膜", "UV", "烫印", "起鼓", "贴面", "模切", "清废", "品检", "粘盒", "粘箱", "手工"};

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public OrderInfoVO findOrderInfo(String time, int flag) {
        OrderInfo orderInfo = new OrderInfo();
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        if (this.findConfigData(flag)) {
            Map<String, String> map = new HashMap<>();
            map.put("time", time);
            HttpEntity httpEntity = new HttpEntity(map, null);
            ResponseEntity responseEntity = null;
            try {
                responseEntity = restTemplate.postForEntity(hdbConstantConfig.getFindWorkUrl(), httpEntity, JSONObject.class);
                if (responseEntity.getStatusCodeValue() == 200) {
                    JSONObject resultJson = (JSONObject) responseEntity.getBody();
                    Object obj = resultJson.get("data");
                    List<Map<String, Object>> list = (List) obj;
                    List<findOrderInfoVO> collect = list.stream().map(item -> MapBeanUtil.mapToObject(item, findOrderInfoVO.class)).collect(Collectors.toList());
                    for (findOrderInfoVO vo : collect) {
                        if (vo.getJobTypeCode() == 1) {
                            orderInfo.setOrderNumIn(vo.getOrderNum());
                            orderInfo.setWorkNumIn(vo.getWorkNum());
                        } else {
                            orderInfo.setOrderNumOut(vo.getOrderNum());
                            orderInfo.setWorkNumOut(vo.getWorkNum());
                        }
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    orderInfo.setQueryTime(sdf.parse(time));
                    orderInfo.setCreateTime(new Date());
                    orderInfo.setIsTrue(1);
                    //根据queryTime查询数据是否存在，存在则更新，反之插入
                    OrderInfo info = orderInfoMapper.findOrderIsOnly(time);
                    if (info != null) {
                        //更新
                        orderInfo.setId(info.getId());
                        orderInfoMapper.updateOrderInfo(orderInfo);
                    } else {
                        //将查询到的订单信息保存到db
                        orderInfoMapper.insert(orderInfo);
                    }
                    BeanUtils.copyProperties(orderInfo, orderInfoVO);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return orderInfoVO;
        } else {
            // 假数据
            return orderInfoMapper.findOrderInfoByTime(time);
        }
    }

    @Override
    public List<ProduceInfoVO> findProduceInfo() {
        return produceMapper.findProduceFalse();
    }

    @Override
    public List<FlowInfoVO> findFlowInfo(String time, int flag) {
        if (this.findConfigData(flag)) {
            List<FlowInfo> flowInfoList = new ArrayList<>();
            List<FlowInfoVO> flowInfoVOList = new ArrayList<>();
            List<FlowInfoVO> resultList = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("time", time);
            HttpEntity httpEntity = new HttpEntity(map, null);
            ResponseEntity responseEntity = null;
            try {
                responseEntity = restTemplate.postForEntity(hdbConstantConfig.getFindFlowUrl(), httpEntity, JSONObject.class);
                if (responseEntity.getStatusCodeValue() == 200) {
                    JSONObject resultJson = (JSONObject) responseEntity.getBody();
                    Object obj = resultJson.get("data");
                    List<Map<String, Object>> list = (List) obj;
                    List<findFlowInfoVO> collect = list.stream().map(item -> MapBeanUtil.mapToObject(item, findFlowInfoVO.class)).collect(Collectors.toList());
                    Date queryTime = sdf.parse(time);
                    Date createTime = new Date();
                    for (findFlowInfoVO vo : collect) {
                        FlowInfo flowInfo = new FlowInfo();
                        FlowInfoVO flowInfoVO = new FlowInfoVO();
                        //后端数据库赋值
                        flowInfo.setQueryTime(queryTime);
                        flowInfo.setCreateTime(createTime);
                        flowInfo.setServiceName(vo.getServiceName());
                        flowInfo.setPlanQuantity(vo.getPlanQuantity());
                        flowInfo.setActualQuantity(Integer.valueOf(vo.getActualQuantity() == null ? "0" : vo.getActualQuantity().toString()));
                        flowInfo.setIsTrue(1);
                        flowInfoList.add(flowInfo);
                        //前端页面数据展示
                        BeanUtils.copyProperties(flowInfo, flowInfoVO);
                        flowInfoVOList.add(flowInfoVO);
                    }
                    //根据queryTime查询数据是否存在，存在则更新，反之插入
                    List<FlowInfo> flowInfos = flowInfoMapper.findFlowInfoByTime(time);
                    if (flowInfos.size() > 0) {
                        //先删除
                        flowInfoMapper.delFlowInfoById(flowInfos);
                        //再插入
                        flowInfoMapper.saveFlowInfo(flowInfoList);
                    } else {
                        //后端数据库保存
                        if (flowInfoList.size() > 0) {
                            flowInfoMapper.saveFlowInfo(flowInfoList);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            if (flowInfoVOList.size() > 0) {
                for (int i = 0; i < order.length; i++) {
                    for (FlowInfoVO vo : flowInfoVOList) {
                        if (order[i].equals(vo.getServiceName())) {
                            resultList.add(vo);
                        }
                    }
                }
            }

            return resultList;
        } else {
            //假数据展示
            List<FlowInfoVO> flowInfoFalse = flowInfoMapper.findFlowInfoFalse(time);
            //先查询假数据配置范围是否有变化
            DataRang dataRang=dataRangMapper.selectByPrimaryKey(1);

            //如果不存在，则进行保存
            if((flowInfoFalse.size()<1) || (dataRang.getIsOpen()==1)){
                try {
                    List<FlowInfo> flowInfos=new ArrayList<>();
                    //根据当前日期查询当月的订单总数
                    int orderNum=orderInfoMapper.getOrderNum(time);
                    int printNum=orderNum/30;//印刷数
                    double sgNum= printNum * 0.33;//上光
                    double tmNum=printNum*0.2;//贴面
                    int mqNUm=printNum/2;//模切
                    double zxNum=tmNum;//粘箱
                    int zhNUm=printNum/3;//粘盒
                    int[] listNum={printNum,(int)sgNum,(int)tmNum,mqNUm,(int)zxNum,zhNUm};

                    String[] listName={"印刷","上光","贴面","模切","粘箱","粘盒"};
                    for(int i=0;i<listNum.length;i++){
                        FlowInfo info=new FlowInfo();
                        info.setServiceName(listName[i]);
                        info.setPlanQuantity(listNum[i]);
                        info.setActualQuantity(0);
                        info.setQueryTime(sdf.parse(time));
                        info.setCreateTime(new Date());
                        info.setIsTrue(0);
                        flowInfos.add(info);
                    }
                    //最后更新dataRang的isOpen标志
                    dataRang.setIsOpen(2);
                    dataRangMapper.updateByPrimaryKey(dataRang);

                    //先删除flowInfo假数据
                    flowInfoMapper.delFlowInfoFalseByTime(time);
                    //批量保存flowInfo假数据
                    flowInfoMapper.insertFlowInfoList(flowInfos);
                    //第二遍查询
                    flowInfoFalse = flowInfoMapper.findFlowInfoFalse(time);
                }catch (Exception e){
                    log.info("flow_info假数据保存失败");
                    e.printStackTrace();
                }
            }

            //排序
            List<FlowInfoVO> resultFalse = new ArrayList<>();
            for (int i = 0; i < order.length; i++) {
                for (FlowInfoVO vo : flowInfoFalse) {
                    if (order[i].equals(vo.getServiceName())) {
                        resultFalse.add(vo);
                    }
                }
            }
            return resultFalse;
        }
    }

    @Override
    public List<OrderMonthVO> findOrderMonth(String time, int flag) {
        List<OrderMonthVO> list;
        //计算当前是几号
        int currentDay = Integer.valueOf(time.substring(8, 10));
        //统计当前月份
        int currentMonth = Integer.valueOf(time.substring(5, 7));
        if (this.findConfigData(flag)) {
            //真数据
            list = orderInfoMapper.findOrderMonthTrue(time);
        } else {
            //先查询假数据配置范围是否有变化
            DataRang dataRang=dataRangMapper.selectByPrimaryKey(1);
            if(dataRang.getIsOpen() == 0){
                List<OrderInfo> orderInfoList=new ArrayList<>();
                //订单数据下限
                int down=dataRang.getDataDown();
                //订单数据上限
                int top=dataRang.getDataTop();
                //查询12个月假数据
                List<OrderInfo> orderInfos=orderInfoMapper.selectAllFalse();
                for (OrderInfo info:orderInfos){
                    OrderInfo orderInfo=new OrderInfo();
                    //根据数据范围随机生成每月订单总量
                    //订单
                    int orderNum=(int) (Math.random()*down) + (top-down);
                    int orderNumIn=(int) Math.round(orderNum * 0.8);
                    int orderNumOut=(int) Math.round(orderNum * 0.2);
                    //工单
                    int workNum=Math.round(orderNum/10000);
                    int workNumIn=(int) Math.round(workNum * 0.8);
                    int workNumOut=(int) Math.round(workNum * 0.2);
                    orderInfo.setId(info.getId());
                    orderInfo.setOrderNumIn(orderNumIn);
                    orderInfo.setOrderNumOut(orderNumOut);
                    orderInfo.setWorkNumIn(workNumIn);
                    orderInfo.setWorkNumOut(workNumOut);
                    orderInfoList.add(orderInfo);
                }
                //批量更新orderInfo数据
                orderInfoMapper.updateOrderInfoFalseList(orderInfoList);
                //最后更新dataRang的isOpen标志
                dataRang.setIsOpen(1);
                dataRangMapper.updateByPrimaryKey(dataRang);
            }
            //查询假数据
            list = orderInfoMapper.findOrderMonthFalse(time);
            //假数据排序
            List<OrderMonthVO> orderList=new ArrayList<>();
            int size=list.size();
            if(currentMonth<size){
                for(int i=currentMonth;i<size;i++){
                    orderList.add(list.get(i));
                }
                for(int j=0;j<currentMonth;j++){
                    orderList.add(list.get(j));
                }
                list=orderList;
            }

        }

        if (currentDay < 20 && list.size() > 0) {
            list = list.subList(0, list.size() - 1);
        }
        return list;
    }

    @Override
    public Boolean findConfigData(int flag) {
        if (flag == 0) {
            ConfigData configData = configDataMapper.selectByPrimaryKey(1);
            if (configData.getIsTrue() == 1) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ScreenResultVO findScreenData(String time, int flag) {
        ScreenResultVO vo = new ScreenResultVO();
        vo.setOrderInfoVO(this.findOrderInfo(time, flag));
        vo.setOrderMonthVOList(this.findOrderMonth(time, flag));
        vo.setFlowInfoVOList(this.findFlowInfo(time, flag));
        vo.setProduceInfoVOList(this.findProduceInfo());
        return vo;
    }


}
