package com.dmt.core.service.Impl;

import com.dmt.core.domain.BaseDomain;
import com.dmt.core.domain.Place;
import com.dmt.core.domain.enums.PlaceType;
import com.dmt.core.domain.general.Page;
import com.dmt.core.repository.PlaceRepository;
import com.dmt.core.service.PlaceService;
import com.dmt.core.service.Search.SearchPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.model.SelectItem;
import java.awt.print.Pageable;
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
        typeList.add(new SelectItem(PlaceType.AMFI,"AMFİ"));
        typeList.add(new SelectItem(PlaceType.SINIF,"SINIF"));
        typeList.add(new SelectItem(PlaceType.LAB,"LABORATUVAR"));
        return typeList;
    }

    @Override
    public Place save(Place place) {
        if (place.getId()== null){
        place.setCreDate(new Date());
        place.setId(String.valueOf(new Date().getTime()));
        }else {
            place.setUpdDate(new Date());
        }

        return placeRepository.save(place);
    }

//        @Override
//    public Page<Place> getList(SearchPlace filter, Pageable pageable) {
//        return placeRepository.findAll(PlaceSpec);
//    }
}
