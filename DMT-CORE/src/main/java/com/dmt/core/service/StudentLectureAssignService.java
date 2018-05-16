package com.dmt.core.service;

import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author mali.sahin
 * @since 07.05.2018
 */
public interface StudentLectureAssignService {

    StudentLectureAssign createStudentLectureAssign(StudentLectureAssign lectureAssign);

    public List<StudentLectureAssign> createStudentLectureAssignList(List<StudentLectureAssign> lectureAssignList);

    StudentLectureAssign updateStudentLectureAssign(StudentLectureAssign lectureAssign) throws Exception;

    void deleteStudentLectureAssign(String lectureAssignId) throws Exception;

    StudentLectureAssign findStudentLectureAssign(String lectureAssignId);

    List<StudentLectureAssign> findStudentLectureAssigns(SearchStudentLectureAssign filter);

    Page<StudentLectureAssign> findStudentLectureAssigns(SearchStudentLectureAssign filter, Pageable pageable);
}
