package com.dmt.core.service.Impl;

import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.domain.dto.ExamNoteDto;
import com.dmt.core.repository.StudentLectureAssignRepository;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
import com.dmt.core.service.StudentLectureAssignService;
import com.dmt.core.service.spec.StudentLectureAssignSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author mali.sahin
 * @since 07.05.2018
 */
@Service
public class StudentLectureAssignServiceImpl implements StudentLectureAssignService {

    @Autowired
    private StudentLectureAssignRepository studentLectureAssignRepository;


    @Override
    public StudentLectureAssign createStudentLectureAssign(StudentLectureAssign lectureAssign) {
        lectureAssign.setId(String.valueOf(new Date().getTime()));
        lectureAssign.setCreDate(new Date());
        return studentLectureAssignRepository.save(lectureAssign);
    }

    @Override
    public List<StudentLectureAssign> createStudentLectureAssignList(List<StudentLectureAssign> lectureAssignList) {
        for (StudentLectureAssign assign : lectureAssignList) {
            assign.setCreDate(new Date());
            assign.setId(String.valueOf(new Date().getTime()));
        }
        return studentLectureAssignRepository.saveAll(lectureAssignList);
    }

    @Override
    public StudentLectureAssign updateStudentLectureAssign(StudentLectureAssign studentLectureAssign) throws Exception {
        if (!studentLectureAssignRepository.existsById(studentLectureAssign.getId())) {
            throw new Exception("updateStudentLectureAssign");
        }
        studentLectureAssign.setUpdDate(new Date());
        return studentLectureAssignRepository.save(studentLectureAssign);
    }

    @Override
    public void deleteStudentLectureAssign(String lectureAssignId) throws Exception {
        if (!studentLectureAssignRepository.existsById(lectureAssignId)) {
            throw new Exception("deleteStudentLectureAssign");
        }
        studentLectureAssignRepository.deleteById(lectureAssignId);
    }

    @Override
    public StudentLectureAssign findStudentLectureAssign(String lectureAssignId) {
        return studentLectureAssignRepository.getOne(lectureAssignId);
    }

    @Override
    public List<StudentLectureAssign> findStudentLectureAssigns(SearchStudentLectureAssign filter) {
        return studentLectureAssignRepository.findAll(StudentLectureAssignSpec.findByCriteria(filter));
    }

    @Override
    public List<StudentLectureAssign> findStudentLectureAssigns() {
        return studentLectureAssignRepository.findAll();
    }

    @Override
    public Page<StudentLectureAssign> findStudentLectureAssigns(SearchStudentLectureAssign filter, Pageable pageable) {
        return studentLectureAssignRepository.findAll(StudentLectureAssignSpec.findByCriteria(filter), pageable);
    }

    @Override
    public List<ExamNoteDto> getExamNoteList(String id) {
        SearchStudentLectureAssign filter = new SearchStudentLectureAssign();
        filter.setStudentId(id);
        List<StudentLectureAssign> list = findStudentLectureAssigns(filter);
        list.forEach(item -> {
            /**/
        });
        return null;
    }
}
