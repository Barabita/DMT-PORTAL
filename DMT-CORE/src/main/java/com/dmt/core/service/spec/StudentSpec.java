package com.dmt.core.service.spec;

import com.dmt.core.domain.Student;
import com.dmt.core.domain.search.StudentSearch;
import org.springframework.data.jpa.domain.Specification;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mali.sahin
 * @date 24-Mar-18
 */
public class StudentSpec {


    public static Specification<Student> findByCriteria(final Student searchCriteria) {

        return new Specification<Student>() {

            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
