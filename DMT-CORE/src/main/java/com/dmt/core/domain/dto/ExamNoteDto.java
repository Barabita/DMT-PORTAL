package com.dmt.core.domain.dto;

/**
 * @author mali.sahin
 * @since 03-Jun-18
 */
public class ExamNoteDto {

    private String lecture;
    private String instructor;
    private int visa1;
    private int visa2;
    private int finalResult;
    private int credit;

    public ExamNoteDto() {
    }

    public ExamNoteDto(String lecture, String instructor, int visa1, int visa2, int finalResult, int credit) {
        this.lecture = lecture;
        this.instructor = instructor;
        this.visa1 = visa1;
        this.visa2 = visa2;
        this.finalResult = finalResult;
        this.credit = credit;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getVisa1() {
        return visa1;
    }

    public void setVisa1(int visa1) {
        this.visa1 = visa1;
    }

    public int getVisa2() {
        return visa2;
    }

    public void setVisa2(int visa2) {
        this.visa2 = visa2;
    }

    public int getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(int finalResult) {
        this.finalResult = finalResult;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
