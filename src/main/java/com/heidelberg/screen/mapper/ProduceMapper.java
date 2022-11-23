package com.heidelberg.screen.mapper;

import com.heidelberg.screen.model.ProduceInfo;
import com.heidelberg.screen.vo.ProduceInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProduceMapper extends Mapper<ProduceInfo> {

    //查询假数据
    List<ProduceInfoVO> findProduceFalse();
}
