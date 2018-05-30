package com.dmt.core.service.Impl;

import com.dmt.core.domain.Summary;
import com.dmt.core.repository.SummaryRepository;
import com.dmt.core.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private SummaryRepository summaryRepository;

    public List<Summary> findByEmail(String email) {
        return summaryRepository.findByEmail(email);
    }
}
