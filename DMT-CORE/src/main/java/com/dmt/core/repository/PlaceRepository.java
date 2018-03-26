package com.dmt.core.repository;

import com.dmt.core.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: mali.sahin on 26.03.2018.
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, String>, JpaSpecificationExecutor {
}
