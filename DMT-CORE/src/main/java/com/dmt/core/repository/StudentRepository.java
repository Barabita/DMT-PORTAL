package com.dmt.core.repository;

import com.dmt.core.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mali.sahin
 * @date 24-Mar-18
 */
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor {
}
