package com.dmt.core.domain;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class LectureHour implements Serializable {

    @Column(name = "TERM", length = 10)
    int term;

    @Column(name = "WEEKLY_COUNT", length = 50)
    int weeklyCount;

}
