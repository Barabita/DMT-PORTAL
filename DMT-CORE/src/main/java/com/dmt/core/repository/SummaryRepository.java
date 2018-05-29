package com.dmt.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */
public interface SummaryRepository extends JpaRepository<SummaryRepository, Long>, JpaSpecificationExecutor {
}
