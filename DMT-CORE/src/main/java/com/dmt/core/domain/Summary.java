package com.dmt.core.domain;

import com.dmt.core.domain.general.SummaryPk;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */
@Entity
@Table(name = "SUMMARY_DEF")
public class Summary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private SummaryPk id;

    @Column(name = "INSTRUCTOR_NAME")
    private String instructorName;

    @Column(name = "INSTRUCTOR_SURNAME")
    private String instructorSurname;

    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "STUDENT_SURNAME")
    private String studentSurname;

    @Column(name = "LECTURE_ID")
    private String lectureId;

    @Column(name = "LECTURE_NAME")
    private String lectureName;

    @Column(name = "LECTURE_CODE")
    private String lectureCode;

    @Column(name = "HOURS")
    private int eventHours;



    @Column(name = "PLACE_NAME")
    private String placeName;
    @Column(name = "EMAIL")
    private String email;

    public SummaryPk getId() {
        return id;
    }

    public void setId(SummaryPk id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorSurname() {
        return instructorSurname;
    }

    public void setInstructorSurname(String instructorSurname) {
        this.instructorSurname = instructorSurname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureCode() {
        return lectureCode;
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }

    public int getEventHours() {
        return eventHours;
    }

    public void setEventHours(int eventHours) {
        this.eventHours = eventHours;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
