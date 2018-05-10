package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.domain.Lecture;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.InstructorService;
import com.dmt.core.service.LectureService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.Search.SearchLecture;
import com.dmt.web.util.FacesUtil;

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

    private List<SelectItem> lectureList = new ArrayList<SelectItem>();
    private List<SelectItem> instructorList = new ArrayList<SelectItem>();
    private List<InstructorLectureAssign> assignList = new ArrayList<>();
    private InstructorLectureAssign assign = new InstructorLectureAssign();

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
        assignList = this.instructorLectureAssignService.findInstructorLectureAssigns(new SearchInstuctorLectureAssign());
    }

    public void save() throws Exception {
        if (saveKontrol()) {
            if (assign.getId() == null || assign.getId().equals("")) {
                assign.setInstructorId(assign.getInstructor().getId());
                assign.setLectureId(assign.getLecture().getId());
                this.instructorLectureAssignService.save(assign);
            } else {
                this.instructorLectureAssignService.updateInstructorLectureAssign(assign);
            }
            assign = new InstructorLectureAssign();
            prepareAssignList();
        }
    }

    private boolean saveKontrol() {
        if (assign.getLecture().getId() == null || assign.getLecture().getId().equals("")) {
            FacesUtil.giveError("Dersin adı zorunlu alandır.");
            return false;
        }
        if (assign.getInstructor().getId() == null || assign.getInstructor().getId().equals("")) {
            FacesUtil.giveError("Eğitmen seçimi zorunlu alandır.");
            return false;
        }

        if (assign.getName() == null || assign.getName().equals("") || assign.getName().length() < 6) {
            FacesUtil.giveError("Lütfen geçerli bir ders kodu giriniz.");
            return false;
        }

        return true;
    }

    public void update(InstructorLectureAssign lectureAssign) {
        this.assign = lectureAssign;
    }


    public void delete(InstructorLectureAssign assign) throws Exception {
        this.getInstructorLectureAssignService().deleteInstructorLectureAssign(assign.getId());
        prepareAssignList();
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

    public InstructorLectureAssign getAssign() {
        return assign;
    }

    public void setAssign(InstructorLectureAssign assign) {
        this.assign = assign;
    }
}
