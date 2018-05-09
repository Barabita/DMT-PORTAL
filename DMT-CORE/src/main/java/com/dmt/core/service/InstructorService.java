package com.dmt.core.service;
import org.springframework.data.domain.Pageable;
import com.dmt.core.domain.Instructor;

import java.util.List;


public interface InstructorService {
    public Instructor save(Instructor instructor);

    public List<Instructor> getInstructorList(Instructor filter, Pageable pageable);

    public List<Instructor> getInstructorList(Instructor filter);

    public void delete(Instructor instructor);

    void update(Instructor instructor);
}
