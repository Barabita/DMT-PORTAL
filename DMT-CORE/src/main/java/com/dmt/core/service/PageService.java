package com.dmt.core.service;

import com.dmt.core.domain.general.Page;
import org.springframework.stereotype.Service;

/**
 * @author mali.sahin
 * @date 21-Mar-18
 */

public interface PageService {

    /**
     * @param name
     * @return
     */
    public Page getOne(String name);


    public Page findByName(String name);
}
