package com.heidelberg.screen.mapper;

import com.heidelberg.screen.model.OrderInfo;
import com.heidelberg.screen.vo.OrderInfoVO;
import com.heidelberg.screen.vo.OrderMonthVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.annotation.Order;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoMapper extends Mapper<OrderInfo> {

    OrderInfoVO findOrderInfoByTime(String time);

    //查询每月订单假数据
    List<OrderMonthVO> findOrderMonthFalse(String time);

    //查询每月订单真数据
    List<OrderMonthVO> findOrderMonthTrue(String time);

    OrderInfo findOrderIsOnly(String time);

    void updateOrderInfo(OrderInfo info);

    int getOrderNum(String time);

    //查询所有订单假数据
    List<OrderInfo> selectAllFalse();

    //批量更新订单每月假数据
    void updateOrderInfoFalseList(@Param("infos") List<OrderInfo> infos);

}
