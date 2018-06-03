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
@Table(name = "STUDENT_LECTURE_ASSIGN")
public class StudentLectureAssign extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "STUDENT_ID", nullable = false)
    private String studentId;

    @Column(name = "INSTRUCTOR_LECTURE_ID", nullable = false)
    private String instructorLectureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "STUDENT_ID")
    @Fetch(FetchMode.JOIN)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "INSTRUCTOR_LECTURE_ID")
    @Fetch(FetchMode.JOIN)
    private InstructorLectureAssign instructorLectureAssign;

    @Column(name = "VISA1")
    private int visa1;


    @Column(name = "VISA2")
    private int visa2;


    @Column(name = "FINAL")
    private int finalResult;

    public int getVisa1() {
        return visa1;
    }

    public void setVisa1(int visa1) {
        this.visa1 = visa1;
    }

    public int getVisa2() {
        return visa2;
    }

    public void setVisa2(int visa2) {
        this.visa2 = visa2;
    }

    public int getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(int finalResult) {
        this.finalResult = finalResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getInstructorLectureId() {
        return instructorLectureId;
    }

    public void setInstructorLectureId(String instructorLectureId) {
        this.instructorLectureId = instructorLectureId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public InstructorLectureAssign getInstructorLectureAssign() {
        return instructorLectureAssign;
    }

    public void setInstructorLectureAssign(InstructorLectureAssign instructorLectureAssign) {
        this.instructorLectureAssign = instructorLectureAssign;
    }
}
