package com.test.tasktwo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
public class Sample {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer parentId;
    @Column
    private String name;
    @Column
    private String color;
}