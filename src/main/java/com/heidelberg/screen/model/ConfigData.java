package com.heidelberg.screen.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "config_data")
public class ConfigData {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "is_true")
    private Integer isTrue;
}
