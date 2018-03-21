package com.dmt.core.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INSTRUCTOR_DEF")
public class Instructor implements Serializable {


    @Column(name = "ISIM", length = 150, nullable = false)
    String isim;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "SURNAME", length = 150, nullable = false)
    String surname;

    @Column(name = "NATIONAL_ID", length = 11, nullable = false)
    int nationalId;

    @Column(name = "ROOM_NO", length = 11)
    int roomNo;

    @Column(name = "GSM_NO", length = 11)
    int gsmNo;

    @Column(name = "INTERNAL_NO", length = 11)
    int internalNo;

    @Column(name = "EMAIL", length = 200)
    String email;

    @Column(name = "WEEKLY_LECTURE_RES", length = 11)
    int weeklyLectureRes;

    @Column(name = "PLEASURE", length = 11)
    int pleasure;

}