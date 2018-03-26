package com.dmt.core.service.Impl;

import com.dmt.core.repository.StudentGroupRepository;
import com.dmt.core.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mali.sahin
 * @date 26.03.2018
 */

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    @Autowired
    private StudentGroupRepository studentGroupRepository;
}
