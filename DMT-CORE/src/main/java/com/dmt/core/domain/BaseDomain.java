package com.dmt.core.domain;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mali.sahin
 * @since 24-Mar-18
 */
public class BaseDomain implements Serializable {
    @Column(name = "CRE_USER", nullable = false, length = 36)
    private String creUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CRE_DATE", nullable = false)
    private Date creDate;

    @Column(name = "UPD_USER", nullable = true, length = 36)
    private String updUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPD_DATE", nullable = true)
    private Date updDate;


    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }
}
