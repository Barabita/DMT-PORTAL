package com.dmt.core.service.Impl;

import com.dmt.core.domain.Student;
import com.dmt.core.domain.search.StudentSearch;
import com.dmt.core.repository.PageRepository;
import com.dmt.core.repository.StudentRepository;
import com.dmt.core.service.StudentService;
import com.dmt.core.service.spec.StudentSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author mali.sahin
 * @date 24-Mar-18
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public Student save(Student student) {
        student.setCreDate(new Date());
        student.setId(String.valueOf(new Date().getTime()));
        return studentRepository.save(student);
    }

    public List<Student> getStudentList(Student filter, Pageable pageable) {
        return studentRepository.findAll(StudentSpec.findByCriteria(filter), pageable).getContent();
    }
}
