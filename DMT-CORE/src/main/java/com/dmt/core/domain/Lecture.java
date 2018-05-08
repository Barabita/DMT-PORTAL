package com.dmt.core.domain;

import com.dmt.core.util.Excelable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "LECTURE_DEF")
public class Lecture extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", length = 20, nullable = false)
    @Excelable(enabled = true)
    private String id;

    @Column(name = "CODE", length = 10, nullable = false)
    @Excelable(enabled = true, value = "DERS KODU")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeeklyLectureCount() {
        return weeklyLectureCount;
    }

    public void setWeeklyLectureCount(int weeklyLectureCount) {
        this.weeklyLectureCount = weeklyLectureCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
