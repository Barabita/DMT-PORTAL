package com.dmt.core.repository;

import com.dmt.core.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureForInstructorRepository  extends JpaRepository<Lecture, String>, JpaSpecificationExecutor {
}
