package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.domain.Lecture;
import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.StudentLectureAssignService;
import com.dmt.core.service.StudentService;
import com.dmt.web.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 03-Jun-18
 */
@ViewScoped
@ManagedBean(name = "examNotesView")
public class ExamNotesView implements Serializable {

    @ManagedProperty("#{studentServiceImpl}")
    private StudentService studentService;

    @ManagedProperty("#{studentLectureAssignServiceImpl}")
    private StudentLectureAssignService studentLectureAssignService;


    @ManagedProperty("#{instructorLectureAssignServiceImpl}")
    private InstructorLectureAssignService instructorLectureAssignService;

    private Instructor selectedInstructor = new Instructor();
    private Lecture selectedLecture = new Lecture();
    private List<StudentLectureAssign> assignList = new ArrayList<>();
    private List<StudentLectureAssign> dataList = new ArrayList<>();
    private List<Instructor> instructorList = new ArrayList<>();
    private List<Lecture> lectureList = new ArrayList<>();

    @PostConstruct
    public void init() {
        prepareDataList();
        prepareInstructorList();
    }

    private void prepareDataList() {
        dataList = studentLectureAssignService.findStudentLectureAssigns();
    }


    public List<Instructor> prepareInstructorList() {
        dataList.forEach(item -> {
            if (!instructorList.contains(item.getInstructorLectureAssign().getInstructor()))
                instructorList.add(item.getInstructorLectureAssign().getInstructor());
        });
        return instructorList;
    }

    public List<Lecture> prepareLectureList() {
        lectureList.clear();
        if (selectedInstructor.getId() != null) {
            dataList.forEach(item -> {
                if (selectedInstructor.getId().equals(item.getInstructorLectureAssign().getInstructorId())) {
                    lectureList.add(item.getInstructorLectureAssign().getLecture());
                }
            });
            prepareAssigList();
        }

        return lectureList;
    }

    public List<StudentLectureAssign> prepareAssigList() {
        assignList.clear();
        boolean check = selectedInstructor != null && selectedInstructor.getId() != null &&
                selectedLecture != null & selectedLecture.getId() != null;
        if (check) {
            dataList.forEach(item -> {
                boolean isInstructorSame = selectedInstructor.getId().equals(item.getInstructorLectureAssign().getInstructorId());
                boolean isLectureSame = selectedLecture.getId().equals(item.getInstructorLectureAssign().getLectureId());
                if (isInstructorSame && isLectureSame) {
                    this.assignList.add(item);
                }
            });
        }
        return assignList;
    }

    public void update(StudentLectureAssign item) throws Exception {
        studentLectureAssignService.updateStudentLectureAssign(item);
        FacesUtil.giveError("Exam results are recorded");
    }

    /*----------------------------------------------------------------------------------------------------*/

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentLectureAssignService getStudentLectureAssignService() {
        return studentLectureAssignService;
    }

    public void setStudentLectureAssignService(StudentLectureAssignService studentLectureAssignService) {
        this.studentLectureAssignService = studentLectureAssignService;
    }

    public InstructorLectureAssignService getInstructorLectureAssignService() {
        return instructorLectureAssignService;
    }

    public void setInstructorLectureAssignService(InstructorLectureAssignService instructorLectureAssignService) {
        this.instructorLectureAssignService = instructorLectureAssignService;
    }

    public List<StudentLectureAssign> getAssignList() {
        return assignList;
    }

    public void setAssignList(List<StudentLectureAssign> assignList) {
        this.assignList = assignList;
    }

    public Instructor getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(Instructor selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }

    public Lecture getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(Lecture selectedLecture) {
        this.selectedLecture = selectedLecture;
    }
}
