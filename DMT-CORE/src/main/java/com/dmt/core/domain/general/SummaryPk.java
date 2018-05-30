package com.dmt.core.domain.general;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 30-May-18
 */
@Embeddable
public class SummaryPk implements Serializable {

    @Column(name = "INSTRUCTOR_ID")
    private String instructorId;

    @Column(name = "START_TIME")
    private String eventStartTime;

    @Column(name = "DAYS_OF_WEEK")
    private String daysOfWeek;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SummaryPk)) return false;

        SummaryPk summaryPk = (SummaryPk) o;

        if (instructorId != null ? !instructorId.equals(summaryPk.instructorId) : summaryPk.instructorId != null)
            return false;
        if (eventStartTime != null ? !eventStartTime.equals(summaryPk.eventStartTime) : summaryPk.eventStartTime != null)
            return false;
        return daysOfWeek != null ? daysOfWeek.equals(summaryPk.daysOfWeek) : summaryPk.daysOfWeek == null;

    }

    @Override
    public int hashCode() {
        int result = instructorId != null ? instructorId.hashCode() : 0;
        result = 31 * result + (eventStartTime != null ? eventStartTime.hashCode() : 0);
        result = 31 * result + (daysOfWeek != null ? daysOfWeek.hashCode() : 0);
        return result;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
}
