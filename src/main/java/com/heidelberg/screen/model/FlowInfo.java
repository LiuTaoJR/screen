package com.heidelberg.screen.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "flow_info")
public class FlowInfo {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "plan_quantity")
    private Integer planQuantity;

    @Column(name = "actual_quantity")
    private Integer actualQuantity;

    @Column(name = "query_time")
    private Date queryTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_true")
    private Integer isTrue;
}
