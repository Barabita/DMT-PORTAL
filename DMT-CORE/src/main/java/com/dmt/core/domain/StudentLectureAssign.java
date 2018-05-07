package com.dmt.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */
@Entity
@Table(name = "STUDENT_LECTURE_ASSIGN")
public class StudentLectureAssign extends BaseDomain implements Serializable{

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "STUDENT_ID", nullable = false)
    private String studentId;

    @Column(name = "INSTRUCTOR_LECTURE_ID", nullable = false)
    private String instructorLectureId;

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


}
