package com.dmt.web;

import com.dmt.core.domain.Event;
import com.dmt.core.domain.Place;
import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.domain.enums.DaysOfWeek;
import com.dmt.core.service.EventService;
import com.dmt.core.service.PlaceService;
import com.dmt.core.service.Search.SearchPlace;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
import com.dmt.core.service.StudentLectureAssignService;
import com.dmt.web.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
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
    private List<Event> eventList = new ArrayList<>();

    @PostConstruct
    private void init() {
        this.event = new Event();
        preparePlaceList();
        prepareLectureList();
        prepareEventList();
    }

    private void prepareEventList() {
        this.eventList = this.eventService.findAll();
    }

    private void preparePlaceList() {
        placeList = this.placeService.getPlaceList(new SearchPlace());
    }

    private void prepareLectureList() {
        this.lectureList = this.studentLectureAssignService.findStudentLectureAssigns(new SearchStudentLectureAssign());
    }


    public void save() {
        if (saveKontrol()) {
            this.eventService.save(this.event);
        }
        prepareEventList();
    }

    private boolean saveKontrol() {

        if (this.event.getPlaceID() == null || this.event.getPlaceID().isEmpty()) {
            FacesUtil.giveError("Place can not be null");
            return false;
        }
        if (this.event.getStudentLectureId() == null || this.event.getStudentLectureId().equals("")) {
            FacesUtil.giveError("Instructor Can not be null");
            return false;
        }

        if (this.event.getStartTime() < 8 && this.event.getStartTime() > 18) {
            FacesUtil.giveError("Course can be started between  8 and 18");
            return false;
        }

        if (this.event.getDaysOfWeek() == null) {
            FacesUtil.giveError("Course day can not be null");
            return false;
        }

        return true;
    }

    public void delete(Event event) {
        this.eventService.delete(event.getId());
    }

    public void update(Event event) {
        this.event = event;
    }

    public PlaceService getPlaceService() {
        return placeService;
    }

    public List<SelectItem> dayList() {
        List<SelectItem> list = new ArrayList<>();
        list.add(new SelectItem(DaysOfWeek.MONDAY.getValue(), DaysOfWeek.MONDAY.getValue()));
        list.add(new SelectItem(DaysOfWeek.TUESDAY.getValue(), DaysOfWeek.TUESDAY.getValue()));
        list.add(new SelectItem(DaysOfWeek.WEDNESDAY.getValue(), DaysOfWeek.WEDNESDAY.getValue()));
        list.add(new SelectItem(DaysOfWeek.THURSDAY.getValue(), DaysOfWeek.THURSDAY.getValue()));
        list.add(new SelectItem(DaysOfWeek.FRIDAY.getValue(), DaysOfWeek.FRIDAY.getValue()));

        return list;
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

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}