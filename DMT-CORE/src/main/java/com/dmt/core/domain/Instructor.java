package com.dmt.core.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INSTRUCTOR_DEF")
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getGsmNo() {
        return gsmNo;
    }

    public void setGsmNo(int gsmNo) {
        this.gsmNo = gsmNo;
    }

    public int getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(int internalNo) {
        this.internalNo = internalNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWeeklyLectureRes() {
        return weeklyLectureRes;
    }

    public void setWeeklyLectureRes(int weeklyLectureRes) {
        this.weeklyLectureRes = weeklyLectureRes;
    }

    public int getPleasure() {
        return pleasure;
    }

    public void setPleasure(int pleasure) {
        this.pleasure = pleasure;
    }
}