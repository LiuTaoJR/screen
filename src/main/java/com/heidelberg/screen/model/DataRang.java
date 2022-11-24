package com.heidelberg.screen.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "data_rang")
public class DataRang {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_down")
    private Integer dataDown;

    @Column(name = "data_top")
    private Integer dataTop;

    @Column(name = "is_open")
    private Integer isOpen;
}
