package com.dmt.core.service;

import com.dmt.core.domain.Lecture;
import com.dmt.core.service.Search.SearchLecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: mali.sahin on 26.03.2018.
 */

public interface LectureService {

    public Lecture save(Lecture lecture);

    public Page<Lecture> getList(SearchLecture filter, Pageable pageable);

    public void delete(Lecture lecture);
}
