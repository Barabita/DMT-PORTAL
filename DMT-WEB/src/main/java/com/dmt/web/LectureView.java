package com.dmt.web;

import com.dmt.core.domain.Lecture;
import com.dmt.core.service.LectureService;
import com.dmt.core.service.Search.SearchLecture;
import com.dmt.web.util.FacesUtil;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author mali.sahin
 * @since 28-Mar-18
 */
@ViewScoped
@ManagedBean(name = "lectureView")
public class LectureView implements Serializable {

    @ManagedProperty("#{lectureServiceImpl}")
    private LectureService lectureService;

    private SearchLecture searchLecture;
    public LazyDataModel<Lecture> lectureList;
    private Lecture lecture = new Lecture();

    @PostConstruct
    private void init() {
        searchLecture = new SearchLecture();
        fetchLectureList();
    }

    public void fetchLectureList() {
        lectureList = new LazyDataModel<Lecture>() {
            @Override
            public List<Lecture> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                PageRequest pageRequest = new PageRequest(first, pageSize, Sort.unsorted());
                Page<Lecture> lecturePage = lectureService.getList(searchLecture, pageRequest);
                lectureList.setRowCount((int) lecturePage.getTotalElements());
                return lecturePage.getContent();
            }
        };
        lectureList.setRowCount(1);
    }

    public void save() {
        if (saveKontrol())
            lectureService.save(lecture);
        FacesUtil.giveInfo("The Lecture was registered on a successfully.");
        lecture = new Lecture();
    }

    private Boolean saveKontrol() {
        if (lecture.getName().isEmpty()) {
            FacesUtil.giveError("it is necessary to enter a Lecture Name.");
            return false;
        }
        if (lecture.getLanguage().isEmpty()) {
            FacesUtil.giveError("Please enter a Lecture Language");
            return false;
        }
        if (lecture.getCode().isEmpty()) {
            FacesUtil.giveError("It is necessary to enter a Lecture Code");
            return false;
        }
        return true;
    }

    public void delete(Lecture lecture) {
        lectureService.delete(lecture);
    }

    public void update(Lecture lecture) {
        this.lecture = lecture;
    }


    public LectureService getLectureService() {
        return lectureService;
    }

    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    public SearchLecture getSearchLecture() {
        return searchLecture;
    }

    public void setSearchLecture(SearchLecture searchLecture) {
        this.searchLecture = searchLecture;
    }

    public LazyDataModel<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(LazyDataModel<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
