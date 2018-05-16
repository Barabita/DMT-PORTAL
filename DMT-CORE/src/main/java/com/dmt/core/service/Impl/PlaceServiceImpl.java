package com.dmt.core.service.Impl;

import com.dmt.core.domain.BaseDomain;
import com.dmt.core.domain.Place;
import com.dmt.core.domain.enums.PlaceType;
import com.dmt.core.domain.general.Page;
import com.dmt.core.repository.PlaceRepository;
import com.dmt.core.service.PlaceService;
import com.dmt.core.service.Search.SearchPlace;
import com.dmt.core.service.spec.PlaceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: mali.sahin on 26.03.2018.
 */

@Service
public class PlaceServiceImpl extends BaseDomain implements PlaceService{

    @Autowired
    @Qualifier("placeRepository")
    private PlaceRepository placeRepository;

    @Override
    public List<SelectItem> getPlaceTypeList() {
        List<SelectItem> typeList = new ArrayList<>();
        typeList.add(new SelectItem(PlaceType.AMFI,"AMFI"));
        typeList.add(new SelectItem(PlaceType.SINIF,"SINIF"));
        typeList.add(new SelectItem(PlaceType.LAB,"LABORATUVAR"));
        return typeList;
    }

    @Override
    @Transactional
    public Place save(Place place) {
        place.setCreDate(new Date());
        place.setId(String.valueOf(new Date().getTime()));
        return placeRepository.save(place);
    }

//
//    public Page<Place> getPlaceList (SearchPlace filter ,Pageable pagable){
//
//        return null;
//    }
//
//

    @Override
    public List<Place> getPlaceList(SearchPlace filter) {
        return placeRepository.findAll(PlaceSpec.findByCriteria(filter));
    }
}
