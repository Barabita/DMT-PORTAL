package domain;

import javax.persistence.Column;
import java.io.Serializable;

public class Lecture implements Serializable {

    @Column(name = "ID", length = 11, nullable = false)
    int id;

    @Column(name = "ISIM", length = 150, nullable = false)
    String isim;

    @Column(name = "WEEKLY_LECTURE_COUNT" )
    int weeklyLectureCount;

    @Column(name = "LANGUAGEE" ,length = 50)
    String languagee;

    @Column(name="CREDIT" ,length = 10 ,nullable = false)
    int credit;

    @Column(name = "TERM", length = 10)
    int term;

}
