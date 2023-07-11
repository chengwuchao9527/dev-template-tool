package com.cheng.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author chengwuchao
 * @date 2022/3/18
 */
@Data
@Entity
@Table(name = "user")
public class UserDO extends BaseEntity {

    @Column(name= "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name= "age",columnDefinition = "int(20)")
    private Integer age;
}
