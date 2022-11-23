package com.heidelberg.screen.service;


import com.heidelberg.screen.vo.*;

import java.util.List;

public interface ScreenService {

    //查询订单信息
    OrderInfoVO findOrderInfo(String time, int flag);

    //查询生产设备信息
    List<ProduceInfoVO> findProduceInfo();

    //查询每日工艺生产情况
    List<FlowInfoVO> findFlowInfo(String time, int flag);

    //查询每月订单统计数据
    List<OrderMonthVO> findOrderMonth(String time, int flag);

    //查询真假数据配置
    Boolean findConfigData(int flag);

    //查询大屏所有数据
    ScreenResultVO findScreenData(String time, int flag);
}
