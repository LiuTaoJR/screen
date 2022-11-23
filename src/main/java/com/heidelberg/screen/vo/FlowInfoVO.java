package com.heidelberg.screen.vo;

import lombok.Data;

@Data
public class FlowInfoVO {
    private String serviceName; //工艺名称
    private int planQuantity; //计划值
    private int actualQuantity; //实际值
}
