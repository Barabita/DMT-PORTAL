package com.dmt.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "LECTURE_DEF")
public class Lecture extends BaseDomain implements Serializable  {

    @Id
    @Column(name = "ID", length = 11, nullable = false)
    private String id;

    @Column(name = "NAME", length = 150, nullable = false)
    private String name;

    @Column(name = "WEEKLY_LECTURE_COUNT", length = 2, nullable = false)
    private int weeklyLectureCount;

    @Column(name = "LANGUAGE", length = 50, nullable = false)
    private String language;

    @Column(name = "CREDIT", length = 10, nullable = false)
    private int credit;

    @Column(name = "TERM", length = 1)
    private int term;


}
