package com.dmt.core.domain;


import com.dmt.core.domain.enums.ReceiverType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */
@Entity
@Table(name = "NOTIFICATION_DEF")
public class Notification extends BaseDomain implements Serializable {

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

    @Column(name = "RECEIVER_TYPE", nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private ReceiverType receiverType;

    @Column(name = "TRS_DATE")
    private Date trsDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrsFlag() {
        return trsFlag;
    }

    public void setTrsFlag(String trsFlag) {
        this.trsFlag = trsFlag;
    }

    public ReceiverType getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(ReceiverType receiverType) {
        this.receiverType = receiverType;
    }

    public Date getTrsDate() {
        return trsDate;
    }

    public void setTrsDate(Date trsDate) {
        this.trsDate = trsDate;
    }
}
