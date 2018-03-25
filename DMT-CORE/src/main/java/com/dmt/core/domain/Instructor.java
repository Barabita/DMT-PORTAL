package com.dmt.core.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INSTRUCTOR_DEF")
@Getter
@Setter
public class Instructor extends BaseDomain implements Serializable {


    @Column(name = "NAME", length = 150, nullable = false)
    private String name;

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;


    @Column(name = "SURNAME", length = 150, nullable = false)
    private String surname;

    @Column(name = "NATIONAL_ID", length = 11, nullable = false)
    private int nationalId;

    @Column(name = "ROOM_NO", length = 11)
    private  int roomNo;

    @Column(name = "GSM_NO", length = 11)
    private int gsmNo;

    @Column(name = "INTERNAL_NO", length = 11)
    private int internalNo;

    @Column(name = "EMAIL", length = 200)
    private String email;

    @Column(name = "WEEKLY_LECTURE_RES", length = 11)
    private int weeklyLectureRes;

    @Column(name = "PLEASURE", length = 11)
    private  int pleasure;

}