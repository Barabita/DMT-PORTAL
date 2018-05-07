package com.dmt.web;

import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.domain.Student;
import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.Search.SearchStudent;
import com.dmt.core.service.StudentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 07-May-18
 */
@ViewScoped
@ManagedBean(name = "studentLectureAssign")
public class StudentLectureAssignView implements Serializable {

    @ManagedProperty("#{studentServiceImpl}")
    private StudentService studentService;

    @ManagedProperty("#{studentLectureAssignServiceImpl}")
    private InstructorLectureAssignService instructorLectureAssignService;

    private SelectItem selectedLecture;

    List<SelectItem> lectureList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    List<InstructorLectureAssign> assignList = new ArrayList<>();
    String code = "";

    @PostConstruct
    private void init() {

        prepareStudentList();
        prepareAssignList();
    }

    private void prepareStudentList() {
        PageRequest pageRequest = new PageRequest(0, 20);
        studentList = this.studentService.getStudentList(new SearchStudent(), pageRequest).getContent();
    }

    private void prepareAssignList() {
        PageRequest pageRequest = new PageRequest(0, 20, Sort.unsorted());
        assignList = this.instructorLectureAssignService
                .findInstructorLectureAssigns(new SearchInstuctorLectureAssign(), pageRequest).getContent();


    }

    public void update(StudentLectureAssign assign) {

    }

    public void delete(StudentLectureAssign assign) {

    }

    public InstructorLectureAssignService getInstructorLectureAssignService() {
        return instructorLectureAssignService;
    }

    public void setInstructorLectureAssignService(InstructorLectureAssignService instructorLectureAssignService) {
        this.instructorLectureAssignService = instructorLectureAssignService;
    }


    public List<SelectItem> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<SelectItem> lectureList) {
        this.lectureList = lectureList;
    }

    public List<InstructorLectureAssign> getAssignList() {
        return assignList;
    }

    public void setAssignList(List<InstructorLectureAssign> assignList) {
        this.assignList = assignList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public SelectItem getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(SelectItem selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
