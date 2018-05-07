package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.domain.Lecture;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.InstructorService;
import com.dmt.core.service.LectureService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.Search.SearchLecture;
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
@ManagedBean(name = "instructorLectureAssign")
public class InstructorLectureAssignView implements Serializable {

    @ManagedProperty("#{lectureServiceImpl}")
    private LectureService lectureService;

    @ManagedProperty("#{instructorServiceImpl}")
    private InstructorService instructorService;

    @ManagedProperty("#{instructorLectureAssignServiceImpl}")
    private InstructorLectureAssignService instructorLectureAssignService;

    SelectItem selectedLecture = new SelectItem();
    SelectItem selectedInstructor = new SelectItem();
    List<SelectItem> lectureList = new ArrayList<>();
    List<SelectItem> instructorList = new ArrayList<>();
    List<InstructorLectureAssign> assignList = new ArrayList<>();
    String code = "";

    @PostConstruct
    private void init() {
        prepareInstructorSelectItemList();
        prepareLectureSelectItemList();
        prepareAssignList();
    }

    private void prepareLectureSelectItemList() {
        List<Lecture> lectures = lectureService.getList(new SearchLecture());
        lectures.forEach(item -> lectureList.add(new SelectItem(item.getId(), item.getName())));
    }

    private void prepareInstructorSelectItemList() {
        List<Instructor> instructors = this.instructorService.getInstructorList(new Instructor());
        instructors.forEach(item -> instructorList.add(new SelectItem(item.getId(), item.getName())));
    }

    private void prepareAssignList() {
        PageRequest pageRequest = new PageRequest(0, 20, Sort.unsorted());
        assignList = this.instructorLectureAssignService
                .findInstructorLectureAssigns(new SearchInstuctorLectureAssign(), pageRequest).getContent();


    }

    public void update(InstructorLectureAssign assign) {

    }


    public void delete(InstructorLectureAssign assign) {

    }

    public LectureService getLectureService() {
        return lectureService;
    }

    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    public InstructorService getInstructorService() {
        return instructorService;
    }

    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    public InstructorLectureAssignService getInstructorLectureAssignService() {
        return instructorLectureAssignService;
    }

    public void setInstructorLectureAssignService(InstructorLectureAssignService instructorLectureAssignService) {
        this.instructorLectureAssignService = instructorLectureAssignService;
    }

    public SelectItem getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(SelectItem selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

    public SelectItem getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(SelectItem selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }

    public List<SelectItem> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<SelectItem> lectureList) {
        this.lectureList = lectureList;
    }

    public List<SelectItem> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<SelectItem> instructorList) {
        this.instructorList = instructorList;
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
}
