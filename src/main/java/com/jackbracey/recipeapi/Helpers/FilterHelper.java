package com.jackbracey.recipeapi.Helpers;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class FilterHelper {

    public static void getLikeFilter(String filterValue, String rootValue, HibernateCriteriaBuilder builder,
                                     Root<?> root, List<Predicate> predicates) {
        if (Strings.isNotEmpty(filterValue))
            predicates.add(builder.like(builder.lower(root.get(rootValue)),
                    "%" + filterValue.toLowerCase() + "%"));
    }

    public static void getEqualsFilter(String filterValue, String rootValue, HibernateCriteriaBuilder builder,
                                       Root<?> root, List<Predicate> predicates) {
        if (filterValue != null)
            predicates.add(builder.equal(root.get(rootValue), filterValue));
    }

    public static void getEqualsFilter(Long filterValue, String rootValue, HibernateCriteriaBuilder builder,
                                       Root<?> root, List<Predicate> predicates) {
        if (filterValue != null)
            predicates.add(builder.equal(root.get(rootValue), filterValue));
    }

    public static void getInFilter(List<?> filterValue, String rootValue, HibernateCriteriaBuilder builder,
                                   Root<?> root, List<Predicate> predicates) {
        if (filterValue != null && filterValue.size() > 0)
            predicates.add(builder.in(root.get(rootValue), filterValue));
    }

    public static void getRangeFilter(Integer filterMinValue, Integer filterMaxValue, String rootValue,
                                      HibernateCriteriaBuilder builder, Root<?> root,
                                      List<Predicate> predicates) {
        if (filterMinValue != null || filterMaxValue != null) {
            /* Between 2 values */
            if (filterMinValue != null && filterMaxValue != null)
                predicates.add(builder.and(builder.gt(root.get(rootValue), filterMinValue),
                        builder.lt(root.get(rootValue), filterMaxValue)));

                /* Just more than min */
            else if (filterMinValue != null)
                predicates.add(builder.gt(root.get(rootValue), filterMinValue));

                /* Just less than max */
            else predicates.add(builder.lt(root.get(rootValue), filterMaxValue));
        }
    }

}
