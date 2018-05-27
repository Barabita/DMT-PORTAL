package com.dmt.core.repository;

import com.dmt.core.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author mali.sahin
 * @since 27-May-18
 */
@Repository
public interface EventRepository extends JpaRepository<Event, String>, JpaSpecificationExecutor {
}
