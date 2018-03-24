package com.dmt.web;

import com.dmt.core.domain.Student;
import com.dmt.core.domain.search.StudentSearch;
import com.dmt.core.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.PageRequest;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
@RequestScoped
@ManagedBean(name = "studentView")
@Getter
@Setter
public class StudentView implements Serializable {

    Student student = new Student();
    Student searchStudent = new Student();
    String pageStatus = "LIST";
    LazyDataModel<Student> studentList;
    List<Student> students;

    @ManagedProperty("#{studentServiceImpl}")
    private StudentService studentService;

    @PostConstruct
    public void init() {
        fetchStudentList();
    }

    private void fetchStudentList() {
        studentList = new LazyDataModel<Student>() {
            @Override
            public List<Student> load(int first, int pageSize, String sortField, SortOrder
                    sortOrder, Map<String, Object> filters) {
                PageRequest pageable = new PageRequest(0, 10);
                searchStudent.setName((String) filters.get("name"));
                students = studentService.getStudentList(searchStudent, pageable);
                return students;
            }
        };
        studentList.setRowCount(1);
    }

    public void save(ActionEvent actionEvent) {
        studentService.save(student);
        student = new Student();
    }

    public void update(Student std) {
        student = std;
    }

    public void delete(Student std) {
        studentService.delete(std);
    }

}
