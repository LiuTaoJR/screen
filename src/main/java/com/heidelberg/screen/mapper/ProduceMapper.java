package com.heidelberg.screen.mapper;

import com.heidelberg.screen.model.ProduceInfo;
import com.heidelberg.screen.vo.ProduceInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ProduceMapper extends Mapper<ProduceInfo> {

    //查询假数据vo
    List<ProduceInfoVO> findProduceFalse();

    //查询假数据
    List<ProduceInfo> selectProduceFalse();

    void updateProduceFalseList(List<ProduceInfo> infos);
}
