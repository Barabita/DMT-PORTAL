package com.dmt.core.domain;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */

@Getter
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

}
