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
@Table(name = "produce_info")
public class ProduceInfo {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "overprint_paper")
    private Integer overprintPaper;

    @Column(name = "waste_paper")
    private Integer wastePaper;

    @Column(name = "end_product")
    private Integer endProduct;

    @Column(name = "query_time")
    private Date queryTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_true")
    private Integer isTrue;


}
