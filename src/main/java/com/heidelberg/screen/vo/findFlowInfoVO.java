package com.heidelberg.screen.vo;

import lombok.Data;

@Data
public class findFlowInfoVO {
    private int serviceId;
    private String serviceName;
    private int planQuantity;
    private Object actualQuantity;
}
