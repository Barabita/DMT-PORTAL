package com.dmt.core.repository;

import com.dmt.core.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: mali.sahin on 26.03.2018.
 */

@Repository
public interface LectureRepository extends JpaRepository<Lecture, String>, JpaSpecificationExecutor {
}
