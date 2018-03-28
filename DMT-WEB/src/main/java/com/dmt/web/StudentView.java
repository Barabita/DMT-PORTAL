package com.dmt.web;

import com.dmt.core.domain.Student;
import com.dmt.core.service.Search.SearchStudent;
import com.dmt.core.service.StudentService;
import com.dmt.web.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
@ViewScoped
@ManagedBean(name = "studentView")
@Getter
@Setter
public class StudentView implements Serializable {

    Student student = new Student();
    SearchStudent searchStudent = new SearchStudent();
    String pageStatus = "LIST";
    LazyDataModel<Student> studentList;
    List<Student> students;
    List<SelectItem> educationTypeList;

    @ManagedProperty("#{studentServiceImpl}")
    private StudentService studentService;
    //

    @PostConstruct
    public void init() {
        fetchStudentList();
        fetchEducationTypeList();
    }

    private void fetchStudentList() {
        studentList = new LazyDataModel<Student>() {
            @Override
            public List<Student> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                PageRequest pageable = new PageRequest(first, pageSize);
                Page<Student> studentPage = studentService.getStudentList(searchStudent, pageable);
                studentList.setRowCount((int) studentPage.getTotalElements());
                return studentPage.getContent();
            }
        };
        studentList.setRowCount(1);
    }

    public void fetchEducationTypeList() {
        educationTypeList = studentService.getEducationTypeList();
    }

    public void save(ActionEvent actionEvent) {
        if (saveKontrol())
            studentService.save(student);
        FacesUtil.giveInfo("Öğrenci başarılı bir şekilde kayıt edildi");
        student = new Student();
    }

    public boolean saveKontrol() {
        if (student.getName() == null || student.getName().isEmpty()) {
            FacesUtil.giveError("Ad bilgisi zorunlu alandır.");
            return false;
        }
        if (student.getSurname() == null || student.getSurname().isEmpty()) {
            FacesUtil.giveError("Soyad bilgisi zorunlu alandır.");
            return false;
        }
        if (student.getGsmNo() == null) {
            FacesUtil.giveError("Telefon bilgisi zorunlu alandır.");
            return false;
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            FacesUtil.giveError("E-mail bilgisi zorunlu alandır.");
            return false;
        } else
            return true;
    }

    public void update(Student std) {
        student = std;
    }

    public void delete(Student std) {
        studentService.delete(std);
    }


}
