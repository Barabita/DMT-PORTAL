package com.dmt.core.service.spec;

import com.dmt.core.domain.Instructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mali.sahin
 **/
public class InstructorSpec  {

    public static Specification<Instructor> findByCriteria(final Instructor searchCriteria) {
        return new Specification<Instructor>() {
            @Override
            public Predicate toPredicate(Root<Instructor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(searchCriteria.getId())) {
                    predicates.add(cb.like(root.get("id"), searchCriteria.getId()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getName())) {
                    predicates.add(cb.like(root.get("name"), searchCriteria.getName()));
                }

                if (StringUtils.isNotEmpty(searchCriteria.getSurname())) {
                    predicates.add(cb.like(root.get("surname"), searchCriteria.getSurname()));
                }

                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }

}
