package com.dmt.core.service.Search;

import com.dmt.core.domain.enums.EducationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @date 29-Mar-18
 */
@Getter
@Setter
public class SearchStudent implements Serializable {

    private String id;
    private String name;
    private String surname;
    private Long gsmNo;
    private String term;
    private int creditGotFirst;
    private int creditGotLast;
    private int creditWillFirst;
    private int creditWillLast;
    private String password;
    private String email;
    private EducationType educationType;

}
