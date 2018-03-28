package com.dmt.core.service.spec;

import com.dmt.core.domain.Student;
import com.dmt.core.service.Search.SearchStudent;
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
public class StudentSpec {


    public static Specification<Student> findByCriteria(final SearchStudent searchCriteria) {

        return new Specification<Student>() {

            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(searchCriteria.getName())) {
                    predicates.add(cb.like(root.get("name"), searchCriteria.getName()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getSurname())) {
                    predicates.add(cb.like(root.get("surname"), searchCriteria.getSurname()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getEmail())) {
                    predicates.add(cb.like(root.get("email"), searchCriteria.getEmail()));
                }
/*
                if (StringUtils.isNotEmpty(searchCriteria.getEmail())) {
                    predicates.add(cb.like(root.get("email"), searchCriteria.getEmail()));
                }*/


                if (searchCriteria.getCreditGotFirst() > 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("creditGotFirst"), searchCriteria.getCreditGotFirst()));
                }

                if (searchCriteria.getCreditGotLast() > 0) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("creditGotLast"), searchCriteria.getCreditGotLast()));
                }

                if (searchCriteria.getCreditWillFirst() > 0) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("creditWillFirst"), searchCriteria.getCreditWillFirst()));
                }

                if (searchCriteria.getCreditWillLast() > 0) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("creditWillLast"), searchCriteria.getCreditWillLast()));
                }

                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }
}
