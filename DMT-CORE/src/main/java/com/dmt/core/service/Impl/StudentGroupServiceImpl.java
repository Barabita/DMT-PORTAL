package com.dmt.core.service.Impl;

import com.dmt.core.domain.StudentGroup;
import com.dmt.core.repository.StudentGroupRepository;
import com.dmt.core.service.Search.SearchStudentGroup;
import com.dmt.core.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author mali.sahin
 * @date 26.03.2018
 */

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public StudentGroup save(StudentGroup group) {
        return null;
    }

    @Override
    public Page<StudentGroup> getStudentGroupList(SearchStudentGroup filter, Pageable pageable) {
        return null;
    }

    @Override
    public void delete(StudentGroup student) {

    }
}
