package com.dmt.core.repository;

import com.dmt.core.domain.StudentLectureAssign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository class for LectureAssign entity
 *
 * @author mali.sahin
 * @version 1.0.3, 07.05.2018
 */
@Repository
public interface StudentLectureAssignRepository extends JpaRepository<StudentLectureAssign, String>, JpaSpecificationExecutor {

}
