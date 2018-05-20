package com.dmt.web;

import com.dmt.core.domain.Place;
import com.dmt.core.service.PlaceService;
import com.dmt.core.service.Search.SearchPlace;
import com.dmt.web.util.FacesUtil;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author : yagmur.avsar
 **/
@ViewScoped
@ManagedBean(name = "placeView")
public class PlaceView implements Serializable {

    private Place place = new Place();
    private SearchPlace searchPlace = new SearchPlace();
    private String pageStatus = "LIST";
    private LazyDataModel<Place> placeList;
    private List<Place> places;
    private List<SelectItem> placeTypeList;
    private  SelectItem selectedPlaceType;

    /**
     * TODO
     * Bean adını küçük harfle başlat --placeServiceImpl
     * Place tipleri için generic bir obje_def tablosu yaratılacak. BOS_OBJ_DEF tablosu var. Ordan alabilirsin.
     * Class içinde Get ve Set yaptın ise o attr'i private yapmalısın. List<Place> places; değil ==> private List<Place> places; gibi.
     */
    @PostConstruct
    public void init() {
        fetchPlaceTypeList();
     //   fetchPlaceList();
    }

    @ManagedProperty("#{placeServiceImpl}")
    private PlaceService placeService;

    private void fetchPlaceTypeList() {
        placeTypeList = placeService.getPlaceTypeList();
    }


    public void fetchPlaceList() {
        placeList = new LazyDataModel<Place>() {
//            @Override
//            public List<Place> load(int first,
//                                      int pageSize,
//                                      String sortField,
//                                      SortOrder sortOrder,
//                                      Map<String, Object> filters) {
//                PageRequest pageable = new PageRequest(first, pageSize);
//                Page<Place> placePage = placeService.getPlaceList(searchPlace, pageable);
//                placeList.setRowCount((int) placePage.getTotalElements());
//                return placePage.getContent();
//            }
        };

        placeList.setRowCount(1);

    }

    private Boolean SaveKontrol(){
        if (place.getId().isEmpty()){
            FacesUtil.giveError("it is necessary to enter a Class Code");
            return false;
        }
        if (place.getName().isEmpty()){
            FacesUtil.giveError("it is necessary to enter a Class Name");
            return false;

        }
        if (place.getType() == null){
            FacesUtil.giveError("Please specify class type");
        }

        return true;
    }


    public void save() {
        if (SaveKontrol()) {
            placeService.save(place);
            FacesUtil.giveInfo("The class was registered on a successfully.");
            place = new Place();
        }
    }



    /*----------------------------------------------------------------------------------------------------------------------*/
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;


    }

    public SearchPlace getSearchPlace() {
        return searchPlace;
    }

    public void setSearchPlace(SearchPlace searchPlace) {
        this.searchPlace = searchPlace;
    }

    public String getPageStatus() {
        return pageStatus;
    }

    public void setPageStatus(String pageStatus) {
        this.pageStatus = pageStatus;
    }

    public LazyDataModel<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(LazyDataModel<Place> placeList) {
        this.placeList = placeList;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<SelectItem> getPlaceTypeList() {
        return placeTypeList;
    }

    public void setPlaceTypeList(List<SelectItem> placeTypeList) {
        this.placeTypeList = placeTypeList;
    }

    public PlaceService getPlaceService() {
        return placeService;
    }

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    public SelectItem getSelectedPlaceType() {
        return selectedPlaceType;
    }

    public void setSelectedPlaceType(SelectItem selectedPlaceType) {
        this.selectedPlaceType = selectedPlaceType;
    }
}
