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
