package com.dmt.web;

import com.dmt.core.domain.Place;
import com.dmt.core.service.PlaceService;
import com.dmt.core.service.Search.SearchPlace;
import org.primefaces.model.LazyDataModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;

/**
 * @author: yagmur.avsar
 **/
@ViewScoped
@ManagedBean(name = "placeView")
public class PlaceView implements Serializable{

    Place place = new Place();
    SearchPlace searchPlace = new SearchPlace();
    String pageStatus = "LIST";
    LazyDataModel<Place> placeList;
    List<Place> places;
    List<SelectItem> placeTypeList;


    @PostConstruct
    public void init() {
        fetchPlaceTypeList();
    }

    @ManagedProperty("#{PlaceServiceImpl}")
    private PlaceService placeService;

    private void fetchPlaceTypeList(){
        placeTypeList = placeService.getPlaceTypeList();
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
}
