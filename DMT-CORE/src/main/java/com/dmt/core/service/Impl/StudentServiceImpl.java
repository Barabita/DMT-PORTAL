package com.dmt.core.service.Impl;

import com.dmt.core.domain.Student;
import com.dmt.core.domain.enums.EducationType;
import com.dmt.core.repository.StudentRepository;
import com.dmt.core.service.Search.SearchStudent;
import com.dmt.core.service.StudentService;
import com.dmt.core.service.spec.StudentSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mali.sahin
 * @since 24-Mar-18
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setCreDate(new Date());
            student.setId(String.valueOf(new Date().getTime()));
        } else {
            student.setUpdDate(new Date());
        }
        return studentRepository.save(student);
    }

    public Page<Student> getStudentList(SearchStudent filter, Pageable pageable) {
        return studentRepository.findAll(StudentSpec.findByCriteria(filter), pageable);
    }

    @Override
    public List<Student> getStudentList(SearchStudent filter) {
        return studentRepository.findAll(StudentSpec.findByCriteria(filter));
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public List<SelectItem> getEducationTypeList() {
        List<SelectItem> typeList = new ArrayList<>();
        typeList.add(new SelectItem(EducationType.TR1, "Daytime Education TR"));
        typeList.add(new SelectItem(EducationType.TR2, "Evening Education TR"));
        typeList.add(new SelectItem(EducationType.ENG1, "Daytime Education ENG"));
        typeList.add(new SelectItem(EducationType.ENG2, "Evening Education ENG"));

        return typeList;
    }

    public List<Student> login(String userName, String password) {
        SearchStudent search = new SearchStudent();
        search.setEmail(userName);
        search.setPassword(password);
        return getStudentList(search);

    }
}