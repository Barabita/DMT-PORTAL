package com.dmt.core.service.spec;

import com.dmt.core.domain.InstructorLectureAssign;
import com.dmt.core.service.Search.SearchInstuctorLectureAssign;
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
public class InstructorLectureAssignSpec {
    public static Specification<InstructorLectureAssign> findByCriteria(final SearchInstuctorLectureAssign searchCriteria) {

        return new Specification<InstructorLectureAssign>() {

            @Override
            public Predicate toPredicate(Root<InstructorLectureAssign> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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

                if (StringUtils.isNotEmpty(searchCriteria.getName())) {
                    predicates.add(cb.equal(root.get("name"), searchCriteria.getName()));
                }


                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }

}
