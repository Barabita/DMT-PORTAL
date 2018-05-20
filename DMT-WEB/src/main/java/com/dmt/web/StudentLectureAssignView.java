package com.dmt.web;

import com.dmt.core.domain.*;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.Search.SearchStudent;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
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


    private Lecture selectedLecture = new Lecture();
    private Instructor selectedInstructor = new Instructor();
    private InstructorLectureAssign selectedInstructorLecture = new InstructorLectureAssign();

    private List<Student> studentList = new ArrayList<>();
    private List<Student> selectedStudents = new ArrayList<>();
    private List<StudentLectureAssign> assignedList = new ArrayList<>();

    private StudentLectureAssign studentLectureAssign = new StudentLectureAssign();
    private List<SelectItem> lectureList = new ArrayList<>();
    private List<SelectItem> instructorList = new ArrayList<>();
    private List<InstructorLectureAssign> instructorLectureAssignList = new ArrayList<>();
    private Boolean isPageAssignedList;
    private Boolean isPageNewAssign;
    private Boolean isPageAssignDetail;

    private List<StudentLectureAssign> detailAssignList;
    private InstructorLectureAssign detailAssign = new InstructorLectureAssign();

    @PostConstruct
    private void init() {
        isPageAssignedList = true;
        isPageNewAssign = false;
        isPageAssignDetail = false;
        prepareStudentList();
        prepareAssignedList();
        prepareInstructorLectureAssignList();
    }

    private void prepareStudentList() {
        studentList = this.studentService.getStudentList(new SearchStudent());
    }

    private void prepareAssignedList() {
        assignedList = this.studentLectureAssignService
                .findStudentLectureAssigns(new SearchStudentLectureAssign());
    }

    private void prepareInstructorLectureAssignList() {
        instructorLectureAssignList = this.instructorLectureAssignService.findInstructorLectureAssigns(new SearchInstuctorLectureAssign());
    }

    public List<SelectItem> prepareLectureList() {
        lectureList.clear();
        lectureList.add(new SelectItem("", ""));
        for (InstructorLectureAssign assign : instructorLectureAssignList) {
            SelectItem selectItemLecture = new SelectItem(assign.getLecture(), assign.getLecture().getName());
            if (!lectureList.contains(selectItemLecture)) {
                lectureList.add(selectItemLecture);
            }
        }
        return lectureList;
    }

    public List<SelectItem> prepareInstructorList() {
        instructorList.clear();
        instructorList.add(new SelectItem("", ""));
        for (InstructorLectureAssign assign : instructorLectureAssignList) {
            boolean isLectureSelected = selectedLecture.getId() != null;
            if (isLectureSelected && selectedLecture.getId().equals(assign.getLectureId())) {
                instructorList.add(new SelectItem(assign.getInstructor(), assign.getInstructor().getName()));
            }
        }
        return instructorList;
    }

    public void update(StudentLectureAssign assign) {

    }

    public void delete(StudentLectureAssign assign) {

    }

    public void newAssign() {
        isPageAssignedList = false;
        isPageNewAssign = true;
    }

    public void saveStudentLectureList() {
        for (InstructorLectureAssign assign : instructorLectureAssignList) {
            if (assign.getLectureId().equals(selectedLecture.getId())
                    && assign.getInstructorId().equals(selectedInstructor.getId())) {
                selectedInstructorLecture = assign;
            }
        }

        List<StudentLectureAssign> studentLectureList = new ArrayList<>();
        for (Student student : studentList) {

            StudentLectureAssign studentLectureAssign = new StudentLectureAssign();
            studentLectureAssign.setInstructorLectureId(selectedInstructorLecture.getId());
            studentLectureAssign.setStudentId(student.getId());
            studentLectureList.add(studentLectureAssign);
        }

        this.studentLectureAssignService.createStudentLectureAssignList(studentLectureList);
        init();
    }

    public void goInstructorLectureDetail(InstructorLectureAssign assign) {
        SearchStudentLectureAssign filter = new SearchStudentLectureAssign();
        filter.setInstructorLectureId(assign.getId());
        isPageAssignedList = false;
        isPageNewAssign = false;
        isPageAssignDetail = true;
        this.detailAssign.setInstructor(assign.getInstructor());
        this.detailAssign.setLecture(assign.getLecture());
        this.detailAssignList = this.studentLectureAssignService.findStudentLectureAssigns(filter);
    }

    public void goDetailPage() {
        isPageAssignedList = true;
        isPageNewAssign = false;
        isPageAssignDetail = false;
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

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
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

    public InstructorLectureAssignService getInstructorLectureAssignService() {
        return instructorLectureAssignService;
    }

    public void setInstructorLectureAssignService(InstructorLectureAssignService instructorLectureAssignService) {
        this.instructorLectureAssignService = instructorLectureAssignService;
    }

    public List<SelectItem> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<SelectItem> instructorList) {
        this.instructorList = instructorList;
    }

    public StudentLectureAssign getStudentLectureAssign() {
        return studentLectureAssign;
    }

    public void setStudentLectureAssign(StudentLectureAssign studentLectureAssign) {
        this.studentLectureAssign = studentLectureAssign;
    }

    public Lecture getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(Lecture selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

    public Instructor getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(Instructor selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }

    public void setIsPageAssignDetail(Boolean pageAssignDetail) {
        isPageAssignDetail = pageAssignDetail;
    }

    public InstructorLectureAssign getSelectedInstructorLecture() {
        return selectedInstructorLecture;
    }

    public void setSelectedInstructorLecture(InstructorLectureAssign selectedInstructorLecture) {
        this.selectedInstructorLecture = selectedInstructorLecture;
    }

    public Boolean getIsPageAssignDetail() {
        return isPageAssignDetail;
    }

    public List<StudentLectureAssign> getDetailAssignList() {
        return detailAssignList;
    }

    public void setDetailAssignList(List<StudentLectureAssign> detailAssignList) {
        this.detailAssignList = detailAssignList;
    }

    public InstructorLectureAssign getDetailAssign() {
        return detailAssign;
    }

    public void setDetailAssign(InstructorLectureAssign detailAssign) {
        this.detailAssign = detailAssign;
    }
}
