package com.dmt.core.service.spec;

import com.dmt.core.domain.Place;
import com.dmt.core.service.Search.SearchPlace;
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
 **/
public class PlaceSpec {
    public static Specification<Place> findByCriteria(final SearchPlace searchCriteria) {

        return new Specification<Place>() {
            @Override
            public Predicate toPredicate(Root<Place> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(searchCriteria.getName())) {
                    predicates.add(cb.like(root.get("name"), searchCriteria.getName()));
                }
                if (StringUtils.isNotEmpty(searchCriteria.getId())) {
                    predicates.add(cb.like(root.get("id"), searchCriteria.getId()));
                }


                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
    }
}
