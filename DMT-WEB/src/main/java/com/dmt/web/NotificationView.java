package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.domain.Notification;
import com.dmt.core.domain.Student;
import com.dmt.core.domain.enums.ReceiverType;
import com.dmt.core.service.InstructorService;
import com.dmt.core.service.NotificationService;
import com.dmt.core.service.Search.SearchStudent;
import com.dmt.core.service.StudentService;
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
 * @since 13-Mar-18
 */
@ViewScoped
@ManagedBean(name = "notificationView")
public class NotificationView implements Serializable {


    @ManagedProperty("#{studentServiceImpl}")
    private StudentService studentService;

    @ManagedProperty("#{notificationServiceImpl}")
    private NotificationService notificationService;

    @ManagedProperty("#{instructorServiceImpl}")
    private InstructorService instructorService;

    private List<Student> studentList;
    private List<Instructor> instructorList;
    private Notification notification;

    @PostConstruct
    public void init() {
        this.notification = new Notification();
    }

    public List<SelectItem> prepareSenderList() {
        List<SelectItem> senderList = new ArrayList<>();
        List<Instructor> instructorList = this.instructorService.getInstructorList(new Instructor());
        for (Instructor instructor : instructorList) {
            senderList.add(new SelectItem(instructor.getId(), instructor.getName() + " " + instructor.getSurname()));
        }
        return senderList;
    }

    public List<SelectItem> prepareReceiverList() {
        List<SelectItem> receiverList = new ArrayList<>();
        List<Student> studentList = this.studentService.getStudentList(new SearchStudent());
        for (Student student : studentList) {
            receiverList.add(new SelectItem(student.getEmail(), student.getName() + " " + student.getSurname()));
        }
        return receiverList;
    }

    public List<SelectItem> prepareReceiverTypeList() {
        List<SelectItem> receiverTypeList = new ArrayList<>();
        receiverTypeList.add(new SelectItem(ReceiverType.USER, ReceiverType.USER.getValue()));
        receiverTypeList.add(new SelectItem(ReceiverType.GROUP, ReceiverType.GROUP.getValue()));
        return receiverTypeList;
    }

    public void save() {
        try {
            if (saveKontrol()) {
                this.notificationService.save(notification);
            }
            this.notification = new Notification();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean saveKontrol() {
        if (notification.getContent() == null || notification.getContent().isEmpty()) {
            FacesUtil.giveError("Message content can not be empty.");
            return false;
        }
        if (notification.getReceiver() == null || notification.getReceiver().isEmpty()) {
            FacesUtil.giveError("Receiver can not be empty");
            return false;
        }
        if (notification.getReceiverType() == null || notification.getReceiverType().getValue().isEmpty()) {
            FacesUtil.giveError("Receiver Type can not be empty");
            return false;
        }
        if (notification.getTitle() == null || notification.getTitle().isEmpty()) {
            FacesUtil.giveError("Title can not be null");
            return false;
        } else
            return true;
    }


    public void delete(Student std) {
        studentService.delete(std);
    }


    /*----------------------------------------------------------------------------------------------------------------------*/


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

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public InstructorService getInstructorService() {
        return instructorService;
    }

    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }
}
