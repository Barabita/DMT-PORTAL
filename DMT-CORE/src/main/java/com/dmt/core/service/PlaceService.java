package com.dmt.core.service;


import com.dmt.core.domain.Place;
import com.dmt.core.service.Search.SearchPlace;

import javax.faces.model.SelectItem;
import java.util.List;

/**
 * @author: yagmur.avsar on 26.03.2018.
 */


public interface PlaceService {

 public List<SelectItem> getPlaceTypeList();

 public Place save(Place place);

// public Page<Place> getPlaceList(SearchPlace filter, Pageable pageable);

 public List<Place> getPlaceList(SearchPlace filter);

}
