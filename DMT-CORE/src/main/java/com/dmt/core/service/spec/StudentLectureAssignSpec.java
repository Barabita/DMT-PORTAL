package com.dmt.core.service.spec;

import com.dmt.core.domain.StudentLectureAssign;
import com.dmt.core.service.Search.SearchStudentLectureAssign;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 07-May-18
 */
public class StudentLectureAssignSpec {
    public static Specification<StudentLectureAssign> findByCriteria(final SearchStudentLectureAssign searchCriteria) {

        return new Specification<StudentLectureAssign>() {

            @Override
            public Predicate toPredicate(Root<StudentLectureAssign> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(searchCriteria.getId())) {
                    predicates.add(cb.equal(root.get("id"), searchCriteria.getId()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getInstructorId())) {
                    predicates.add(cb.equal(root.get("instructorId"), searchCriteria.getInstructorId()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getLectureId())) {
                    predicates.add(cb.equal(root.get("lectureId"), searchCriteria.getLectureId()));
                }
                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }

}
