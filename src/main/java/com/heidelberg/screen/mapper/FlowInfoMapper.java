package com.heidelberg.screen.mapper;

import com.heidelberg.screen.model.FlowInfo;
import com.heidelberg.screen.vo.FlowInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FlowInfoMapper extends Mapper<FlowInfo> {

    //批量保存flowInfo数据
    void saveFlowInfo(List<FlowInfo> flowInfos);

    //查询假数据
    List<FlowInfoVO> findFlowInfoFalse();

    //更新
    void updateFlowInfo(FlowInfo flowInfo);

    //批量删除
    void delFlowInfoById(List<FlowInfo> flowInfos);

    List<FlowInfo> findFlowInfoByTime(String time);
}
