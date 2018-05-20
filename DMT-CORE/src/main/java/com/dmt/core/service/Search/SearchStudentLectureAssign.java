package com.dmt.core.service.Search;

/**
 * @author mali.sahin
 * @since 07-May-18
 */

public class SearchStudentLectureAssign {
    private String id;
    private String instructorLectureId;
    private String studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructorLectureId() {
        return instructorLectureId;
    }

    public void setInstructorLectureId(String instructorLectureId) {
        this.instructorLectureId = instructorLectureId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
