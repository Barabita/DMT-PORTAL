package com.dmt.core.service.Impl;

import com.dmt.core.domain.Lecture;
import com.dmt.core.repository.LectureRepository;
import com.dmt.core.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return lectureRepository.save(lecture);
    }

    @Override
    public List<Lecture> getList(Lecture filter, Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Lecture lecture) {
        lectureRepository.delete(lecture);
    }
}
