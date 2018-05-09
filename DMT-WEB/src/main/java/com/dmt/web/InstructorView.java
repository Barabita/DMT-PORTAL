package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.service.InstructorService;
import com.dmt.web.util.FacesUtil;
import org.springframework.data.util.Lazy;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * @author yagmur.avsar
 **/
@ViewScoped
@ManagedBean(name = "instructorView")
public class InstructorView implements Serializable {
    private Instructor instructor = new Instructor();
    private Instructor searchInstructor = new Instructor();
    private List<Instructor> instructorList;
    private Lazy<Instructor> instructors;


    @ManagedProperty("#{instructorServiceImpl}")
    private InstructorService instructorService;

    @PostConstruct
    public void init() {
        fetchInstructorList();
    }


    private void fetchInstructorList() {
        instructorList = instructorService.getInstructorList(searchInstructor);
    }


    public void save() {
        if (saveKontrol()) {
            if (instructor.getId() == null || instructor.getId().equals("")) {
                instructorService.save(instructor);
            } else {
                instructorService.update(instructor);
            }
            fetchInstructorList();
            instructor = new Instructor();
        }
    }

    private boolean saveKontrol() {
        if (instructor.getName() == null || instructor.getName().isEmpty()) {
            FacesUtil.giveError("Ad bilgisi zorunlu alandır.");
            return false;
        }
        if (instructor.getSurname() == null || instructor.getSurname().isEmpty()) {
            FacesUtil.giveError("Soyad bilgisi zorunlu alandır.");
            return false;
        }
        if (String.valueOf(instructor.getGsmNo()).length() != 10) {
            FacesUtil.giveError("Lütfen doğru telefon formatı giriniz.");
            return false;
        }
        if (String.valueOf(instructor.getNationalId()).length() != 11) {
            FacesUtil.giveError("Girdiğiniz Kimlik numarası geçerli değildir.");
            return false;
        }
        if (instructor.getEmail() == null || instructor.getEmail().isEmpty()) {
            FacesUtil.giveError("E-mail bilgisi zorunlu alandır.");
            return false;
        } else
            return true;
    }


    public void delete(Instructor instructor) {
        instructorService.delete(instructor);
        fetchInstructorList();
    }

    public void update(Instructor inst) {
        this.instructor = inst;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getSearchInstructor() {
        return searchInstructor;
    }

    public void setSearchInstructor(Instructor searchInstructor) {
        this.searchInstructor = searchInstructor;
    }


    public Lazy<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Lazy<Instructor> instructors) {
        this.instructors = instructors;
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


