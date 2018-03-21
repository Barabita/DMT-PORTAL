package com.dmt.core.repository;

import com.dmt.core.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String>, JpaSpecificationExecutor {
}
