package com.heidelberg.screen.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("hdb")
@Data
public class HdbConstantConfig {

    //订单接口
    private String findWorkUrl;

    //工艺情况接口
    private String findFlowUrl;
}
