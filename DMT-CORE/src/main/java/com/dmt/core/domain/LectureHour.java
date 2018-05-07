package com.dmt.core.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class LectureHour implements Serializable {

    @Column(name = "TERM", length = 10)
    int term;

    @Column(name = "WEEKLY_COUNT", length = 50)
    int weeklyCount;

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getWeeklyCount() {
        return weeklyCount;
    }

    public void setWeeklyCount(int weeklyCount) {
        this.weeklyCount = weeklyCount;
    }
}
