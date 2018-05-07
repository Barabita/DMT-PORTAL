package com.dmt.core.service.Impl;

import com.dmt.core.domain.Instructor;
import com.dmt.core.repository.InstructorRepository;
import com.dmt.core.service.InstructorService;
import com.dmt.core.service.spec.InstructorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: mali.sahin
 **/
@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    @Qualifier("instructorRepository")
    private InstructorRepository instructorRepository;

    @Override
    @Transactional
    public Instructor save (Instructor instructor){
        instructor.setCreDate(new Date());
        instructor.setId(String.valueOf(new Date().getTime()));
        return instructorRepository.save(instructor);

    }

    @Override
    public void delete(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    public List<Instructor> getInstructorList(Instructor filter, Pageable pageable) {
        return instructorRepository.findAll(InstructorSpec.findByCriteria(filter) ,pageable).getContent();
    }

    @Override
    public List<Instructor> getInstructorList(Instructor filter) {
        return instructorRepository.findAll(InstructorSpec.findByCriteria(filter));
    }
}
