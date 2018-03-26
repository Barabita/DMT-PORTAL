package com.dmt.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: mali.sahin on 26.03.2018.
 */


@Getter
@Setter
@Entity
@Table(name = "STUDENT_GROUP_DEF")
public class StudentGroup extends  BaseDomain implements Serializable {


    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;


    @Column(name = "LECTURE", nullable = false)
    private String lecture;

    @Column(name = "INSTRUCTOR", nullable = false)
    private String surname;
}
