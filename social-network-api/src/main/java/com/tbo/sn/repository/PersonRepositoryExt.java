package com.tbo.sn.repository;

import com.tbo.sn.domain.node.Hobby;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.domain.node.School;

import java.util.List;

/**
 * Additional data capabilities for a {@link Person}.
 * @see
 * <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition">repository
 * definition</a>
 * @author tai
 * @since 3/17/18.
 */
public interface PersonRepositoryExt
{
    /**
     * Find people who goes to the same school and share the same hobbies with the person with given id.
     * @return list of people whom the person has not followed, who attend a same school and share same
     * hobbies with the person.
     */
    Iterable<Person> findPeopleWhoAttendSameSchoolAndShareSameHobbyToFollow(Long personId);
}
