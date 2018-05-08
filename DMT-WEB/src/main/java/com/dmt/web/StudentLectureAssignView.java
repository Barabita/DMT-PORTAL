package com.dmt.web;

import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.domain.Student;
import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.Search.SearchStudent;
import com.dmt.core.service.StudentLectureAssignService;
import com.dmt.core.service.StudentService;

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
    private StudentLectureAssignService studentLectureAssignService;


    @ManagedProperty("#{instructorLectureAssignServiceImpl}")
    private InstructorLectureAssignService instructorLectureAssignService;

    private SelectItem selectedLecture;
    private List<Student> selectedStudents = new ArrayList<>();
    private List<StudentLectureAssign> assignedList = new ArrayList<>();

    private List<SelectItem> lectureList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private List<InstructorLectureAssign> instructorLectureAssignList = new ArrayList<>();
    private Boolean isPageAssignedList;
    private Boolean isPageNewAssign;
    private String code = "";

    @PostConstruct
    private void init() {
        isPageAssignedList = true;
        isPageNewAssign = false;

        prepareStudentList();
        prepareAssignedList();
    }

    private void prepareStudentList() {
        studentList = this.studentService.getStudentList(new SearchStudent());
    }

    private void prepareAssignedList() {
        StudentLectureAssign assign = new StudentLectureAssign();

        assignedList = this.studentLectureAssignService.findStudentLectureAssigns(new StudentLectureAssign());
    }

    private void prepareInstructorLectureAssignList() {
        InstructorLectureAssign instructorLectureAssign = new InstructorLectureAssign();
        instructorLectureAssign.setLectureId(selectedLecture.getValue());
        instructorLectureAssignList = this.instructorLectureAssignService.findInstructorLectureAssigns(instructorLectureAssign);
    }

    public void update(StudentLectureAssign assign) {

    }

    public void delete(StudentLectureAssign assign) {

    }

    public void newAssign() {
        isPageAssignedList = false;
        isPageNewAssign = true;
    }

    public void assignSelectedList() {
        init();
    }


    public List<SelectItem> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<SelectItem> lectureList) {
        this.lectureList = lectureList;
    }

    public List<InstructorLectureAssign> getInstructorLectureAssignList() {
        return instructorLectureAssignList;
    }

    public void setInstructorLectureAssignList(List<InstructorLectureAssign> instructorLectureAssignList) {
        this.instructorLectureAssignList = instructorLectureAssignList;
    }

    public Boolean getPageAssignedList() {
        return isPageAssignedList;
    }

    public void setPageAssignedList(Boolean pageAssignedList) {
        isPageAssignedList = pageAssignedList;
    }

    public Boolean getPageNewAssign() {
        return isPageNewAssign;
    }

    public void setPageNewAssign(Boolean pageNewAssign) {
        isPageNewAssign = pageNewAssign;
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

    public StudentLectureAssignService getStudentLectureAssignService() {
        return studentLectureAssignService;
    }

    public void setStudentLectureAssignService(StudentLectureAssignService studentLectureAssignService) {
        this.studentLectureAssignService = studentLectureAssignService;
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    public List<StudentLectureAssign> getAssignedList() {
        return assignedList;
    }

    public void setAssignedList(List<StudentLectureAssign> assignedList) {
        this.assignedList = assignedList;
    }

    public Boolean getIsPageAssignedList() {
        return isPageAssignedList;
    }

    public void setIsPageAssignedList(Boolean pageAssignedList) {
        isPageAssignedList = pageAssignedList;
    }

    public Boolean getIsPageNewAssign() {
        return isPageNewAssign;
    }

    public void setIsPageNewAssign(Boolean pageNewAssign) {
        isPageNewAssign = pageNewAssign;
    }


}
