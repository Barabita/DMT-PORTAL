package com.dmt.core.service.Impl;

import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.repository.StudentLectureAssignRepository;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
import com.dmt.core.service.StudentLectureAssignService;
import com.dmt.core.service.spec.StudentLectureAssignSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    public StudentLectureAssign updateStudentLectureAssign(StudentLectureAssign lectureAssign) throws Exception {
        if (!studentLectureAssignRepository.existsById(lectureAssign.getId())) {
            throw new Exception("updateStudentLectureAssign");
        }
        lectureAssign.setUpdDate(new Date());
        return studentLectureAssignRepository.save(lectureAssign);
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
    public List<StudentLectureAssign> findStudentLectureAssigns(StudentLectureAssign filter) {
        return studentLectureAssignRepository.findAll(Example.of(filter, ExampleMatcher.matching().withIgnoreNullValues()));
    }

    @Override
    public Page<StudentLectureAssign> findStudentLectureAssigns(SearchStudentLectureAssign filter, Pageable pageable) {
        return studentLectureAssignRepository.findAll(StudentLectureAssignSpec.findByCriteria(filter), pageable);
    }
}
