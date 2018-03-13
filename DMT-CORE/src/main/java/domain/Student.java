package domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
/*
@Entity
@Table(name = "STUDENT")*/
public class Student {
/*
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "DEALER_ID")
    private String dealerId;

    @Column(name = "BRANCH_ID")
    private String branchId;

    @Column(name = "NAME")
    private String name;

    @Type(type = "tr.com.sistek.b2b.util.jsontype.FileUserType")
    @Column(name = "IMAGE")
    private File image;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "IDENTIFICATION_NO", length = 11)
    private String identificationNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "PASSWORD", length = 100, nullable = true)
    private String password;

    @Column(name = "PASSWORD_HISTORY")
    private List<String> passwordHistory;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PASSWORD_CHANGE_DATE")
    private Date passwordChangeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_DATE")
    private Date lastLoginDate;

    @Column(name = "LOGIN_ATTEMPT", nullable = false)
    private Integer loginAttempt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOCK_DATE")
    private Date lockDate;

    @Type(type = "yes_no")
    @Column(name = "ACTIVATED", nullable = false, columnDefinition = "VARCHAR(1) default 'N'")
    private Boolean activated;


    @Column(name = "ACTIVATION_KEY")
    private String activationKey;

    @Column(name = "RESET_PASSWORD_KEY")
    private String resetPasswordKey;

    @Column(name = "LANGUAGE", nullable = false)
    private String language;

    @Column(name = "TIME_ZONE", nullable = false)
    private String timeZone;

    @Type(type = "yes_no")
    @Column(name = "VALID", nullable = false)
    private Boolean valid = true;
*/

}
