package com.dmt.core.service.Search;

import com.dmt.core.domain.enums.EducationType;

import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 29-Mar-18
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getGsmNo() {
        return gsmNo;
    }

    public void setGsmNo(Long gsmNo) {
        this.gsmNo = gsmNo;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCreditGotFirst() {
        return creditGotFirst;
    }

    public void setCreditGotFirst(int creditGotFirst) {
        this.creditGotFirst = creditGotFirst;
    }

    public int getCreditGotLast() {
        return creditGotLast;
    }

    public void setCreditGotLast(int creditGotLast) {
        this.creditGotLast = creditGotLast;
    }

    public int getCreditWillFirst() {
        return creditWillFirst;
    }

    public void setCreditWillFirst(int creditWillFirst) {
        this.creditWillFirst = creditWillFirst;
    }

    public int getCreditWillLast() {
        return creditWillLast;
    }

    public void setCreditWillLast(int creditWillLast) {
        this.creditWillLast = creditWillLast;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }
}
