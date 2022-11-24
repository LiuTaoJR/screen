package com.heidelberg.screen.mapper;

import com.heidelberg.screen.model.FlowInfo;
import com.heidelberg.screen.vo.FlowInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface FlowInfoMapper extends Mapper<FlowInfo> {

    //批量保存flowInfo数据
    void saveFlowInfo(List<FlowInfo> flowInfos);

    //查询假数据VO
    List<FlowInfoVO> findFlowInfoFalse(String time);

    //更新
    void updateFlowInfo(FlowInfo flowInfo);

    //批量删除
    void delFlowInfoById(List<FlowInfo> flowInfos);

    List<FlowInfo> findFlowInfoByTime(String time);

    //批量插入
    void insertFlowInfoList(List<FlowInfo> flowInfos);

    //查询假数据
    List<FlowInfo> findFlowInfoFalseEntity(String time);

    //批量更新
    void updateFlowInfoList(List<FlowInfo> flowInfos);

    //根据queryTime删除假数据
    int delFlowInfoFalseByTime(String time);

}
