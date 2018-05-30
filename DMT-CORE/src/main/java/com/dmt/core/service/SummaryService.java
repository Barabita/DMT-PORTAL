package com.dmt.core.service;

import com.dmt.core.domain.Summary;

import java.util.List;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */
public interface SummaryService {

    public List<Summary> findByEmail(String email);
}
