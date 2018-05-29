package com.dmt.core.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */

@Entity
@Table(name = "EVENT_DEF")
public class Event implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "PLACE_ID", length = 20)
    private String placeID;

    @Column(name = "DAYS_OF_WEEK")
    private String daysOfWeek;

    @Column(name = "START_TIME")
    private int startTime;

    @Column(name = "STUDENT_LECTURE_ID")
    private String studentLectureId;

    @Column(name = "SESSION")
    private int session;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "STUDENT_LECTURE_ID")
    @Fetch(FetchMode.JOIN)
    private StudentLectureAssign studentLectureAssign;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "PLACE_ID")
    @Fetch(FetchMode.JOIN)
    private Place place;

    @Column(name = "HOURS")
    private int hours = 1;

    @Column(name = "CRE_DATE")
    private Date creDate;

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaceID() {
        return placeID;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getStudentLectureId() {
        return studentLectureId;
    }

    public void setStudentLectureId(String studentLectureId) {
        this.studentLectureId = studentLectureId;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public StudentLectureAssign getStudentLectureAssign() {
        return studentLectureAssign;
    }

    public void setStudentLectureAssign(StudentLectureAssign studentLectureAssign) {
        this.studentLectureAssign = studentLectureAssign;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


}
