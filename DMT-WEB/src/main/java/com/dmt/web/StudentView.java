package com.dmt.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
@SessionScoped
@ManagedBean(name = "studentView")
public class StudentView implements Serializable {

    private String selam = "Merhaba Dunya";

    public String getSelam() {
        return selam;
    }

    public void setSelam(String selam) {
        this.selam = selam;
    }
}
