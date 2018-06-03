package com.dmt.web.general;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 02-Jun-18
 */
@ViewScoped
@ManagedBean(name = "dashboardView")
public class DashboardView implements Serializable{

    private List<String> images;


    @PostConstruct
    public void init(){
     images = new ArrayList<>();
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180512145853140.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180512145749300.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180516143449237.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180417101324937.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20171208112754455.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180106005846220.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180512145853140.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180512145749300.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180516143449237.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180417101324937.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20171208112754455.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180106005846220.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180512145853140.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180512145749300.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180516143449237.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180417101324937.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20171208112754455.jpg");
        images.add("https://www.dogus.edu.tr/Content/images/slider/20180106005846220.jpg");
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
