package com.dmt.core.service.Impl;

import com.dmt.core.domain.enums.PlaceType;
import com.dmt.core.repository.PlaceRepository;
import com.dmt.core.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mali.sahin on 26.03.2018.
 */

@Service
public class PlaceServiceImpl  implements PlaceService{

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


}
