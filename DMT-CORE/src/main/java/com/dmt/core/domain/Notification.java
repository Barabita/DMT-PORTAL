package com.dmt.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "NOTIFICATION_DEF")
class Notification extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;

    @Column(name = "SENDER", nullable = false, length = 20)
    private String sender;

    @Column(name = "RECEIVER", nullable = false, length = 50)
    private String receiver;


    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Column(name = "CONTENT", nullable = false, length = 1000)
    private String content;

    @Column(name = "TRS_FLAG", length = 5)
    private String trsFlag;

    @Column(name = "EXPIRY_DATE", nullable = false)
    private Date expiryDate;

    @Column(name = "RECEIVER_TYPE", nullable = false, length = 5)
    private String receiverType;

    @Column(name = "TRS_DATE")
    private Date trsDate;


}
