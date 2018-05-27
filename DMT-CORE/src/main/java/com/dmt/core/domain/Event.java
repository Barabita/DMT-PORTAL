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
public class Event extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "PLACE_ID", length = 20)
    private String placeID;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

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
    private  Place place;

    private int hours;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
