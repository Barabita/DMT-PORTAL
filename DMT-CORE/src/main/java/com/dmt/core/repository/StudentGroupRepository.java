package com.dmt.core.repository;

import com.dmt.core.domain.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: mali.sahin on 26.03.2018.
 */

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, String>, JpaSpecificationExecutor {
}
