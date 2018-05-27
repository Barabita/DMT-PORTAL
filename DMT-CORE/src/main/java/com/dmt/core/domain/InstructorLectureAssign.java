package com.dmt.core.domain;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */

@Entity
@Table(name = "INSTRUCTOR_LECTURE_ASSIGN")
public class InstructorLectureAssign extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LECTURE_ID", updatable = false)
    private String lectureId;

    @Column(name = "INSTRUCTOR_ID", updatable = false)
    private String instructorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn (name = "INSTRUCTOR_ID")
    @Fetch(FetchMode.JOIN)
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn (name = "LECTURE_ID")
    @Fetch(FetchMode.JOIN)
    private Lecture lecture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
