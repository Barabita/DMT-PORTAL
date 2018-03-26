package com.dmt.core.service.spec;

import com.dmt.core.domain.Lecture;
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


    public static Specification<Lecture> findByCriteria(final Lecture searchCriteria) {

        return new Specification<Lecture>() {

            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(searchCriteria.getId())) {
                    predicates.add(cb.like(root.get("id"), searchCriteria.getId()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getName())) {
                    predicates.add(cb.like(root.get("name"), searchCriteria.getName()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getLanguage())) {
                    predicates.add(cb.like(root.get("language"), searchCriteria.getLanguage()));
                }


                if (StringUtils.isNotEmpty(searchCriteria.getLanguage())) {
                    predicates.add(cb.like(root.get("language"), searchCriteria.getLanguage()));
                }



                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }
}
