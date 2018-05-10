package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.domain.Lecture;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.InstructorService;
import com.dmt.core.service.LectureService;
import com.dmt.core.service.Search.SearchLecture;

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

    private Lecture selectedLecture = new Lecture();
    private Instructor selectedInstructor = new Instructor();
    private List<SelectItem> lectureList = new ArrayList<SelectItem>();
    private List<SelectItem> instructorList = new ArrayList<SelectItem>();
    private List<InstructorLectureAssign> assignList = new ArrayList<>();
    private String code = "";

    @PostConstruct
    private void init() {
        prepareAssignList();
    }

    public List<SelectItem> prepareLectureSelectItemList() {
        lectureList.clear();
        List<Lecture> lectures = lectureService.getList(new SearchLecture());
        for (Lecture item : lectures) {
            lectureList.add(new SelectItem(item, item.getName()));
        }
        return lectureList;
    }

    public List<SelectItem> prepareInstructorSelectItemList() {
        instructorList.clear();
        List<Instructor> instructors = this.instructorService.getInstructorList(new Instructor());
        for (Instructor item : instructors) {
            instructorList.add(new SelectItem(item, item.getName()));
        }
        return instructorList;
    }

    private void prepareAssignList() {
        assignList = this.instructorLectureAssignService.findInstructorLectureAssigns(new InstructorLectureAssign());
    }

    public void save() {
        if (saveKontrol()) {
            InstructorLectureAssign assign = new InstructorLectureAssign();

            assign.setName(code);
            this.instructorLectureAssignService.save(assign);
        }
    }

    private boolean saveKontrol() {
       /* if (selectedLecture.getValue() == null || selectedLecture.getValue().equals("")) {
            FacesUtil.giveError("Dersin adı zorunlu alandır.");
            return false;
        }
        if (selectedInstructor.getValue() == null || selectedInstructor.getValue().equals("")) {
            FacesUtil.giveError("Eğitmen seçimi zorunlu alandır.");
            return false;
        }

        if (code == null || code.equals("") || code.length() < 6) {
            FacesUtil.giveError("Lütfen geçerli bir ders kodu giriniz.");
            return false;
        }*/

        return true;
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
