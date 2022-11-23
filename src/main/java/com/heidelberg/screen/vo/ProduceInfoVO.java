package com.heidelberg.screen.vo;

import lombok.Data;

@Data
public class ProduceInfoVO {

    private String equipmentName; //设备名称
    private int overprintPaper; //过版数
    private int wastePaper; //废张数
    private int endProduct; //成品数
}
