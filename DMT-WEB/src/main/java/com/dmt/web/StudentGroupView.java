package com.dmt.web;

import com.dmt.core.domain.StudentGroup;
import com.dmt.core.service.StudentGroupService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author mali.sahin
 * @since 2.05.2018
 */

@ViewScoped
@ManagedBean
@Getter
@Setter
public class StudentGroupView {

    @Autowired
    StudentGroupService studentGroupService;

    StudentGroup group;

}
