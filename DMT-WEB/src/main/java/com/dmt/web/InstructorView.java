package com.dmt.web;

import com.dmt.core.domain.Instructor;
import com.dmt.core.service.InstructorService;
import com.dmt.web.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Lazy;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: yagmur.avsar
 **/
@RequestScoped
@ManagedBean(name = "instructorView")
@Getter
@Setter
public class InstructorView implements Serializable{
    Instructor instructor = new Instructor();
    Instructor searchInstructor = new Instructor();
    String pageStatus = "LIST" ;
    LazyDataModel<Instructor> instructorList ;
    Lazy<Instructor> instructors;


    @ManagedProperty("#{instructorServiceImpl}")
    private InstructorService instructorService ;

    @PostConstruct
    public void init() {
        fetchInstructorList();
    }


    private void fetchInstructorList(){
        instructorList = new LazyDataModel<Instructor>() {
            @Override
            public List<Instructor> load(int first, int pageSize, String sortField, SortOrder
                    sortOrder, Map<String, Object> filters){
                PageRequest pageable = new PageRequest(first, pageSize);
                return instructorService.getInstructorList(searchInstructor, pageable);
            }
        };
        instructorList.setRowCount(1);
    }




    public void save() {
            instructorService.save(instructor);
           instructor = new Instructor();
    }


    public void delete(Instructor instructor){
        instructorService.delete(instructor);
    }






}


