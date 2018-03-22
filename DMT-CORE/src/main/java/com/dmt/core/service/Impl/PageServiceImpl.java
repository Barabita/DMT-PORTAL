package com.dmt.core.service.Impl;

import com.dmt.core.domain.general.Page;
import com.dmt.core.repository.PageRepository;
import com.dmt.core.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mali.sahin
 * @date 21-Mar-18
 */
@Service
@Transactional
public class PageServiceImpl implements PageService {

    @Autowired
    @Qualifier("pageRepository")
    private PageRepository pageRepository;

    public Page getOne(String name) {
        return pageRepository.getOne(name);
    }

    public Page findByName(String name) {
        return pageRepository.findByName(name);
    }
}
