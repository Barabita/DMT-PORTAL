package com.dmt.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */
@Getter
@Setter
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
}
