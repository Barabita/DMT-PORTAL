package com.dmt.core.service;

import com.dmt.core.domain.Lecture;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: mali.sahin on 26.03.2018.
 */

public interface LectureService {

    public Lecture save(Lecture lecture);

    public List<Lecture> getList(Lecture filter, Pageable pageable);

    public void delete(Lecture lecture);
}
