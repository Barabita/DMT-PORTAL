package com.dmt.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */

@Entity
@Table(name = "EVENT_DEF")
public class Event {

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
}
