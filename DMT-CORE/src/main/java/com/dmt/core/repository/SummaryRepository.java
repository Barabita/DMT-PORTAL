package com.dmt.core.repository;

import com.dmt.core.domain.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */
@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long>, JpaSpecificationExecutor {

    public List<Summary> findByEmail(String email);
}
