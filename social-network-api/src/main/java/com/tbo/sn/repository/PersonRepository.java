package com.tbo.sn.repository;


import com.tbo.sn.domain.node.Person;
import com.tbo.sn.domain.node.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Data access operations on or relating to a {@link Person}
 * @see
 * <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition">repository
 * definition</a>
 * @author tai
 * @since 3/17/18.
 */
@Repository
public interface PersonRepository extends AppRepository<Person>, PersonRepositoryExt
{
    List<Person> findPeopleByGender(String gender);
    Page<Person> findPeopleByGenderAndDobLessThanEqualAndDobGreaterThanEqual(String gender, Date dobRangeStart,
            Date dobRangeEnd, Pageable pageRequest);
    List<Person> findPeopleByDobBetween(Date from, Date to);
}
