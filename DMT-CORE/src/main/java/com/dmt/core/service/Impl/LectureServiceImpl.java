package com.dmt.core.service.Impl;

import com.dmt.core.domain.Lecture;
import com.dmt.core.repository.LectureRepository;
import com.dmt.core.service.LectureService;
import com.dmt.core.service.Search.SearchLecture;
import com.dmt.core.service.spec.LectureSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: mali.sahin on 26.03.2018.
 */

@Service
public class LectureServiceImpl implements LectureService {


    @Autowired
    @Qualifier("lectureRepository")
    private LectureRepository lectureRepository;

    @Override
    public Lecture save(Lecture lecture) {
        lecture.setCreDate(new Date());
        lecture.setId(String.valueOf(new Date().getTime()));
        return lectureRepository.save(lecture);
    }

    @Override
    public Page<Lecture> getList(SearchLecture filter, Pageable pageable) {
        return lectureRepository.findAll(LectureSpec.findByCriteria(filter), pageable);

    }

    @Override
    public void delete(Lecture lecture) {
        lectureRepository.delete(lecture);
    }
}
