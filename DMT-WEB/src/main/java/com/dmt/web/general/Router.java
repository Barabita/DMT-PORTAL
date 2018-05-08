package com.dmt.web.general;


import com.dmt.core.domain.general.Page;
import com.dmt.core.service.PageService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;



@SessionScoped
@ManagedBean(name = "router")
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

    public String getContentPage() {
        return contentPage;
    }

    public void setContentPage(String contentPage) {
        this.contentPage = contentPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PageService getPageService() {
        return pageService;
    }

    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }
}
