package com.heidelberg.screen.mapper;

import com.heidelberg.screen.model.OrderInfo;
import com.heidelberg.screen.vo.OrderInfoVO;
import com.heidelberg.screen.vo.OrderMonthVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderInfoMapper extends Mapper<OrderInfo> {

    OrderInfoVO findOrderInfoByTime(String time);

    //查询每月订单假数据
    List<OrderMonthVO> findOrderMonthFalse(String time);

    //查询每月订单真数据
    List<OrderMonthVO> findOrderMonthTrue(String time);

    OrderInfo findOrderIsOnly(String time);

    void updateOrderInfo(OrderInfo info);

}
