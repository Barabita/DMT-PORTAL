package com.dmt.core.service.Search;

import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 29-Mar-18
 */

public class SearchLecture implements Serializable {

    private String code;
    private String name;
    private int weeklyLectureCountFirst;
    private int weeklyLectureCountLast;
    private String language;
    private int creditFirst;
    private int creditLast;
    private int termFirst;
    private int termLast;

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

    public int getWeeklyLectureCountFirst() {
        return weeklyLectureCountFirst;
    }

    public void setWeeklyLectureCountFirst(int weeklyLectureCountFirst) {
        this.weeklyLectureCountFirst = weeklyLectureCountFirst;
    }

    public int getWeeklyLectureCountLast() {
        return weeklyLectureCountLast;
    }

    public void setWeeklyLectureCountLast(int weeklyLectureCountLast) {
        this.weeklyLectureCountLast = weeklyLectureCountLast;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCreditFirst() {
        return creditFirst;
    }

    public void setCreditFirst(int creditFirst) {
        this.creditFirst = creditFirst;
    }

    public int getCreditLast() {
        return creditLast;
    }

    public void setCreditLast(int creditLast) {
        this.creditLast = creditLast;
    }

    public int getTermFirst() {
        return termFirst;
    }

    public void setTermFirst(int termFirst) {
        this.termFirst = termFirst;
    }

    public int getTermLast() {
        return termLast;
    }

    public void setTermLast(int termLast) {
        this.termLast = termLast;
    }
}
