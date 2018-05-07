package com.dmt.core.domain;

import com.dmt.core.util.Excelable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Data
@Table(name = "LECTURE_DEF")
public class Lecture extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", length = 20, nullable = false)
    @Excelable(enabled = true)
    private String id;

    @Column(name = "CODE", length = 10, nullable = false)
    private String code;

    @Column(name = "NAME", length = 100, nullable = false)
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
