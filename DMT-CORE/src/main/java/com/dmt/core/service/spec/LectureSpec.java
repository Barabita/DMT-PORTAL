package com.dmt.core.service.spec;

import com.dmt.core.domain.Lecture;
import com.dmt.core.service.Search.SearchLecture;
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
 * @date 24-Mar-18
 */
public class LectureSpec {


    public static Specification<Lecture> findByCriteria(final SearchLecture searchCriteria) {

        return new Specification<Lecture>() {

            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(searchCriteria.getName())) {
                    predicates.add(cb.like(root.get("name"), searchCriteria.getName()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getCode())) {
                    predicates.add(cb.like(root.get("code"), searchCriteria.getCode()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getLanguage())) {
                    predicates.add(cb.like(root.get("language"), searchCriteria.getLanguage()));
                }


                if (searchCriteria.getTermFirst() > 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("term"), searchCriteria.getTermFirst()));
                }

                if (searchCriteria.getTermLast() > 0) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("term"), searchCriteria.getTermLast()));
                }


                if (searchCriteria.getCreditFirst() > 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("credit"), searchCriteria.getCreditFirst()));
                }

                if (searchCriteria.getCreditLast() > 0) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("credit"), searchCriteria.getCreditLast()));
                }

                if (searchCriteria.getWeeklyLectureCountFirst() > 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("weeklyLectureCountFirst"), searchCriteria.getWeeklyLectureCountFirst()));
                }

                if (searchCriteria.getWeeklyLectureCountLast() > 0) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("weeklyLectureCountFirst"), searchCriteria.getWeeklyLectureCountLast()));
                }


                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }
}
