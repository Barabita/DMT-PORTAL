package com.dmt.core.service.Search;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mali.sahin
 * @date 29-Mar-18
 */
@Getter
@Setter
public class SearchLecture {

    private String code;
    private String name;
    private int weeklyLectureCountFirst;
    private int weeklyLectureCountLast;
    private String language;
    private int creditFirst;
    private int creditLast;
    private int termFirst;
    private int termLast;

}
