package com.dmt.core.service.Search;

import com.dmt.core.domain.enums.PlaceType;

import java.io.Serializable;

/**
 * @author: yagmur.avsar
 **/
public class SearchPlace implements Serializable {
    private String id;
    private String name;
    private PlaceType placeType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }
}
