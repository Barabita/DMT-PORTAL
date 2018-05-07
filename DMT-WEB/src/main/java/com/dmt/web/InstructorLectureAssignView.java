package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.domain.Lecture;
import com.dmt.core.service.InstructorLectureAssignService;
import com.dmt.core.service.InstructorService;
import com.dmt.core.service.LectureService;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
import com.dmt.core.service.Search.SearchLecture;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import static org.primefaces.component.treetable.TreeTable.PropertyKeys.first;

/**
 * @author mali.sahin
 * @since 07-May-18
 */
@ViewScoped
@ManagedBean(name = "instructorLectureAssign")
@Getter
@Setter
public class InstructorLectureAssignView implements Serializable {

    @ManagedProperty("#{lectureServiceImpl}")
    LectureService lectureService;

    @ManagedProperty("#{instructorServiceImpl}")
    InstructorService instructorService;

    @ManagedProperty("#{instructorLectureAssignServiceImpl}")
    InstructorLectureAssignService instructorLectureAssignService;

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

}
