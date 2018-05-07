package com.dmt.core.service;

import com.dmt.core.domain.StudentGroup;
import com.dmt.core.service.Search.SearchStudentGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author mali.sahin
 * @since 26.03.2018.
 */


public interface StudentGroupService {


    public StudentGroup save(StudentGroup group);

    public Page<StudentGroup> getStudentGroupList(SearchStudentGroup filter, Pageable pageable);

    public void delete(StudentGroup student);

}
