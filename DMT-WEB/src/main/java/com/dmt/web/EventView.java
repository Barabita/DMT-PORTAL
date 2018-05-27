package com.dmt.web;

import com.dmt.core.domain.Event;
import com.dmt.core.domain.Place;
import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.service.EventService;
import com.dmt.core.service.PlaceService;
import com.dmt.core.service.Search.SearchPlace;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
import com.dmt.core.service.StudentLectureAssignService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 27-May-18
 */
@RequestScoped
@ManagedBean(name = "eventView")
public class EventView implements Serializable {

    @ManagedProperty("#{placeServiceImpl}")
    private PlaceService placeService;

    @ManagedProperty("#{studentLectureAssignServiceImpl}")
    private StudentLectureAssignService studentLectureAssignService;

    @ManagedProperty("#{eventServiceImpl}")
    private EventService eventService;
    private Event event;
    private List<Place> placeList = new ArrayList<>();
    private List<StudentLectureAssign> lectureList = new ArrayList<>();


    @PostConstruct
    private void init() {

        preparePlaceList();
        prepareLectureList();
    }

    private void preparePlaceList() {
        placeList = this.placeService.getPlaceList(new SearchPlace());
    }

    private void prepareLectureList() {
        this.lectureList = this.studentLectureAssignService.findStudentLectureAssigns(new SearchStudentLectureAssign());
    }


    public void save() {
        this.eventService.save(this.event);

    }

    public void delete() {
        this.eventService.delete(this.event.getId());
    }

    public void update() {

    }

    public PlaceService getPlaceService() {
        return placeService;
    }

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    public StudentLectureAssignService getStudentLectureAssignService() {
        return studentLectureAssignService;
    }

    public void setStudentLectureAssignService(StudentLectureAssignService studentLectureAssignService) {
        this.studentLectureAssignService = studentLectureAssignService;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public List<StudentLectureAssign> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<StudentLectureAssign> lectureList) {
        this.lectureList = lectureList;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}