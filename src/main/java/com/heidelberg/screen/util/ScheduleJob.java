package com.heidelberg.screen.util;


import com.heidelberg.screen.mapper.FlowInfoMapper;
import com.heidelberg.screen.mapper.ProduceMapper;
import com.heidelberg.screen.model.FlowInfo;
import com.heidelberg.screen.model.ProduceInfo;
import com.heidelberg.screen.service.ScreenService;
import com.heidelberg.screen.vo.FlowInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Slf4j
public class ScheduleJob {

    @Autowired
    private ScreenService screenService;

    @Autowired
    private FlowInfoMapper flowInfoMapper;

    @Autowired
    private ProduceMapper produceMapper;

    @Transactional
    @Scheduled(cron = "0 0 0 * * ?")
    public void yesterdayData() {
        //获取昨天日期
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        try {
            screenService.findScreenData(yesterday, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //flow_info定时任务
    @Transactional
    @Scheduled(cron = "0 0/1 * * * ?")
    public synchronized void updateFlowInfoFalse() {
        try {
            System.out.println("每日工艺汇总开始变化");
            int i=0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String time=sdf.format(new Date());
            List<FlowInfo> flowInfoResult=new ArrayList<>();
            List<FlowInfo> flowInfoList=flowInfoMapper.findFlowInfoFalseEntity(time);
            for (FlowInfo info:flowInfoList){
                FlowInfo flowInfo=new FlowInfo();
                //获取计划数据
                int planNum = info.getPlanQuantity();
                //随机生成4-5之间的数
                double random= (Math.random()+4)/100;
                double addNum= planNum * random;
                int actualNum =(int) Math.round(addNum);
                actualNum=actualNum+info.getActualQuantity();
                //判断实际的数据是否超过计划的数据
                if(actualNum> planNum){
                    actualNum = planNum;
                }
                //如何实际数等于计划数，做一个标记，以后就不用更新了
                if(info.getActualQuantity() == planNum){
                    i=i+1;
                }
                flowInfo.setId(info.getId());
                flowInfo.setActualQuantity(actualNum);
                flowInfoResult.add(flowInfo);
            }
            //批量更新
            if(i != flowInfoList.size()){
                flowInfoMapper.updateFlowInfoList(flowInfoResult);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //produce_info定时任务
    @Transactional
    @Scheduled(cron = "0 0/1 * * * ?")
    public synchronized void updateProduceFalse() {
        System.out.println("当日印刷设备生产情况开始变化");
        List<ProduceInfo> produceInfoList=new ArrayList<>();
        //查询produce假数据
        List<ProduceInfo> produceInfos= produceMapper.selectProduceFalse();
        for(ProduceInfo info:produceInfos){
            Random random=new Random();
            int overNum = random.nextInt(20);
            int wasteNum = random.nextInt(100);
            int endNum = 1000-(overNum+wasteNum);
            info.setOverprintPaper(overNum);
            info.setWastePaper(wasteNum);
            info.setEndProduct(endNum);
            produceInfoList.add(info);
        }
        //批量更新
        produceMapper.updateProduceFalseList(produceInfoList);
    }
}
