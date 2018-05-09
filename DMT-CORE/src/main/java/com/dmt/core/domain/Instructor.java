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
    private String nationalId;

    @Column(name = "ROOM_NO", length = 11)
    private String roomNo;

    @Column(name = "GSM_NO", length = 11)
    private String gsmNo;

    @Column(name = "INTERNAL_NO", length = 11)
    private String internalNo;

    @Column(name = "EMAIL", length = 200)
    private String email;

    @Column(name = "WEEKLY_LECTURE_RES", length = 11)
    private String weeklyLectureRes;

    @Column(name = "PLEASURE", length = 11)
    private String pleasure;


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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getGsmNo() {
        return gsmNo;
    }

    public void setGsmNo(String gsmNo) {
        this.gsmNo = gsmNo;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeeklyLectureRes() {
        return weeklyLectureRes;
    }

    public void setWeeklyLectureRes(String weeklyLectureRes) {
        this.weeklyLectureRes = weeklyLectureRes;
    }

    public String getPleasure() {
        return pleasure;
    }

    public void setPleasure(String pleasure) {
        this.pleasure = pleasure;
    }
}