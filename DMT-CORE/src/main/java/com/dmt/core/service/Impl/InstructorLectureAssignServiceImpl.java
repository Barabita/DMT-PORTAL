package com.dmt.core.service.Impl;

import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.repository.InstructorLectureAssignRepository;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.spec.InstructorLectureAssignSpec;
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
public class InstructorLectureAssignServiceImpl implements InstructorLectureAssignService {

    @Autowired
    private InstructorLectureAssignRepository lectureAssignRepository;


    @Override
    public void save(InstructorLectureAssign assign) {
        assign.setCreDate(new Date());
        assign.setId(String.valueOf(new Date().getTime()));
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
    public List<InstructorLectureAssign> findInstructorLectureAssigns(SearchInstuctorLectureAssign filter) {
        return lectureAssignRepository.findAll(InstructorLectureAssignSpec.findByCriteria(filter));
    }

    public List<InstructorLectureAssign> findInstructorLectureAssigns() {
        return lectureAssignRepository.findAll();
    }

    @Override
    public Page<InstructorLectureAssign> findInstructorLectureAssigns(SearchInstuctorLectureAssign filter, Pageable pageable) {
        return lectureAssignRepository.findAll(InstructorLectureAssignSpec.findByCriteria(filter), pageable);
    }
}
