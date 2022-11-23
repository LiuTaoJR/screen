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
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_num_in")
    private Integer orderNumIn;

    @Column(name = "order_num_out")
    private Integer orderNumOut;

    @Column(name = "work_num_in")
    private Integer workNumIn;

    @Column(name = "work_num_out")
    private Integer workNumOut;

    @Column(name = "query_time")
    private Date queryTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_true")
    private Integer isTrue;
}
