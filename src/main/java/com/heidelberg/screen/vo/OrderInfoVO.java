package com.heidelberg.screen.vo;

import lombok.Data;

@Data
public class OrderInfoVO {

    private int orderNumIn; //订单内盒
    private int orderNumOut; //订单外箱
    private int workNumIn; //工单内盒
    private int workNumOut; //工单外箱
}
