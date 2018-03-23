package com.dmt.web.general;


import com.dmt.core.domain.general.Page;
import com.dmt.core.service.Impl.PageServiceImpl;
import com.dmt.core.service.PageService;
import com.dmt.web.util.FacesUtil;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mali.sahin
 * @date 21-Mar-18
 */

@SessionScoped
@ManagedBean(name = "router")
@Getter
@Setter
public class Router implements Serializable {
    private String contentPage = "";
    private String title = "";

    @ManagedProperty("#{pageServiceImpl}")
    private PageService pageService;


    public void routeContentPage(String url) {
        Page activePage = pageService.findByName(url);
        contentPage = activePage.getUrl();
        title = activePage.getTitle();
    }

}
