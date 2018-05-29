package com.dmt.core.service.Impl;

import com.dmt.core.repository.SummaryRepository;
import com.dmt.core.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private SummaryRepository summaryRepository;
}
