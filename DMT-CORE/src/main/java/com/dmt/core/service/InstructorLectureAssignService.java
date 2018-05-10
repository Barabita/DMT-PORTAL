package com.dmt.core.service;

import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author mali.sahin
 * @since 07.05.2018
 */
public interface InstructorLectureAssignService {

    InstructorLectureAssign createInstructorLectureAssign(InstructorLectureAssign lectureAssign);

    InstructorLectureAssign updateInstructorLectureAssign(InstructorLectureAssign lectureAssign) throws Exception;

    void deleteInstructorLectureAssign(String lectureAssignId) throws Exception;

    InstructorLectureAssign findInstructorLectureAssign(String lectureAssignId);

    List<InstructorLectureAssign> findInstructorLectureAssigns(SearchInstuctorLectureAssign filter);

    Page<InstructorLectureAssign> findInstructorLectureAssigns(SearchInstuctorLectureAssign filter, Pageable pageable);

    void save(InstructorLectureAssign assign);
}
