package com.dmt.core.service.Impl;

import com.dmt.core.repository.PlaceRepository;
import com.dmt.core.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mali.sahin on 26.03.2018.
 */

@Service
public class PlaceServiceImpl  implements PlaceService{

    @Autowired
    private PlaceRepository placeRepository;
}
