package com.dmt.core.service.Impl;

import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.repository.InstructorLectureAssignRepository;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.spec.InstructorLectureAssignSpec;
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
public class InstructorLectureAssignServiceImpl implements InstructorLectureAssignService {

    @Autowired
    private InstructorLectureAssignRepository lectureAssignRepository;


    @Override
    public void save(InstructorLectureAssign assign) {
        lectureAssignRepository.save(assign);
    }

    @Override
    public InstructorLectureAssign createInstructorLectureAssign(InstructorLectureAssign lectureAssign) {
        lectureAssign.setId(String.valueOf(new Date().getTime()));
        lectureAssign.setCreDate(new Date());
        return lectureAssignRepository.save(lectureAssign);
    }

    @Override
    public InstructorLectureAssign updateInstructorLectureAssign(InstructorLectureAssign lectureAssign) throws Exception {
        if (!lectureAssignRepository.existsById(lectureAssign.getId())) {
            throw new Exception("updateInstructorLectureAssign");
        }
        lectureAssign.setUpdDate(new Date());
        return lectureAssignRepository.save(lectureAssign);
    }

    @Override
    public void deleteInstructorLectureAssign(String lectureAssignId) throws Exception {
        if (!lectureAssignRepository.existsById(lectureAssignId)) {
            throw new Exception("deleteInstructorLectureAssign");
        }
        lectureAssignRepository.deleteById(lectureAssignId);
    }

    @Override
    public InstructorLectureAssign findInstructorLectureAssign(String lectureAssignId) {
        return lectureAssignRepository.getOne(lectureAssignId);
    }

    @Override
    public List<InstructorLectureAssign> findInstructorLectureAssigns(InstructorLectureAssign filter) {
        return lectureAssignRepository.findAll(Example.of(filter, ExampleMatcher.matching().withIgnoreNullValues()));
    }

    @Override
    public Page<InstructorLectureAssign> findInstructorLectureAssigns(SearchInstuctorLectureAssign filter, Pageable pageable) {
        return lectureAssignRepository.findAll(InstructorLectureAssignSpec.findByCriteria(filter), pageable);
    }
}
