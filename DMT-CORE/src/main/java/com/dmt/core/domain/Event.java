package com.dmt.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "EVENT_DEF")
public class Event {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "PLACE_ID", length = 20)
    private String placeID;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "STUDENT_LECTURE_ID")
    private String studentLectureId;

    @Column(name = "SESSION")
    private int session;
}
