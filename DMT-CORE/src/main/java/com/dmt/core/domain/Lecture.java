package com.dmt.core.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Lecture implements Serializable {

    @Id
    @Column(name = "ID", length = 11, nullable = false)
    private int id;

    @Column(name = "ISIM", length = 150, nullable = false)
    private String isim;

    @Column(name = "WEEKLY_LECTURE_COUNT")
    private int weeklyLectureCount;

    @Column(name = "LANGUAGEE", length = 50)
    private String languagee;

    @Column(name = "CREDIT", length = 10, nullable = false)
    private int credit;

    @Column(name = "TERM", length = 10)
    private int term;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getWeeklyLectureCount() {
        return weeklyLectureCount;
    }

    public void setWeeklyLectureCount(int weeklyLectureCount) {
        this.weeklyLectureCount = weeklyLectureCount;
    }

    public String getLanguagee() {
        return languagee;
    }

    public void setLanguagee(String languagee) {
        this.languagee = languagee;
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
