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
    }

    @ManagedProperty("#{placeServiceImpl}")
    private PlaceService placeService;

    private void fetchPlaceTypeList() {
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

    public SelectItem getSelectedPlaceType() {
        return selectedPlaceType;
    }

    public void setSelectedPlaceType(SelectItem selectedPlaceType) {
        this.selectedPlaceType = selectedPlaceType;
    }
}
