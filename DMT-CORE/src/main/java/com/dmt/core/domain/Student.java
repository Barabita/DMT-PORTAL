package com.dmt.core.domain;

import com.dmt.core.domain.enums.EducationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @since 13-Mar-18
 */

@Entity
@Table(name = "STUDENT_DEF")
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
    private String password = "adm123";

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "EDUCATION_TYPE", nullable = false)
    private EducationType educationType;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public int getCreditGot() {
        return creditGot;
    }

    public void setCreditGot(int creditGot) {
        this.creditGot = creditGot;
    }

    public int getCreditWill() {
        return creditWill;
    }

    public void setCreditWill(int creditWill) {
        this.creditWill = creditWill;
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
