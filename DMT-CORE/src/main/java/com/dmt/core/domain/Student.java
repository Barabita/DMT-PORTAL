package com.dmt.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */

@Entity
@Table(name = "STUDENT_DEF")
@Getter
@Setter
public class Student extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "GSM_NO", length = 11)
    private Long gsmNo;

    @Column(name = "TERM", nullable = false)
    private String term;

    @Column(name = "CREDIT_GOT")
    private int creditGot;

    @Column(name = "CREDIT_WILL", nullable = false)
    private int creditWill;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "EDUCATION_TYPE", nullable = false)
    private EducationType educationType;


}
