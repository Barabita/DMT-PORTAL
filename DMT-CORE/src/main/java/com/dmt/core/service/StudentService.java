package com.dmt.core.service;

import com.dmt.core.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.faces.model.SelectItem;
import java.util.List;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
public interface StudentService {

    public Student save(Student student);

    public Page<Student> getStudentList(Student filter, Pageable pageable);

    public void delete(Student student);

    public List<SelectItem> getEducationTypeList();
}
