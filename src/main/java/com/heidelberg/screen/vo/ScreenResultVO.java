package com.heidelberg.screen.vo;

import lombok.Data;

import java.util.List;

@Data
public class ScreenResultVO {
    private OrderInfoVO orderInfoVO;//订单数据
    private List<OrderMonthVO> orderMonthVOList;//每月订单趋势
    private List<FlowInfoVO> flowInfoVOList;//每日工艺情况
    private List<ProduceInfoVO> produceInfoVOList;//每日生产设备情况
}
