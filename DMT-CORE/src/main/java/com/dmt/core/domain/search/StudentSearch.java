package com.dmt.core.domain.search;

import com.dmt.core.domain.EducationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author mali.sahin
 * @date 24-Mar-18
 */
@Getter
@Setter
public class StudentSearch {


    private String id;
    private String name;
    private String surname;
    private Long gsmNo;
    private String term;
    private int creditGotFirst = 0;
    private int creditGotLast = 100;
    private int creditWillFirst = 0;
    private int creditWillLast = 100;
    private String password;
    private String email;
    private EducationType educationType;


}
