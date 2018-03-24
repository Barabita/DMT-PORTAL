package com.dmt.core.service;

import com.dmt.core.domain.Student;
import com.dmt.core.domain.search.StudentSearch;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
public interface StudentService {

    public Student save(Student student);

    public List<Student> getStudentList(Student filter, Pageable pageable);

    public void delete(Student student);
}
