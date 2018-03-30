package com.tbo.sn.repository;

import com.tbo.sn.domain.Person;
import com.tbo.sn.domain.education.Education;
import com.tbo.sn.domain.hobby.Hobby;

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
    List<Person> findPeopleToFollowByEducationAndHobbies(List<Education> educationList, List<Hobby> hobbyList);
    List<Person> findFriendsOfFriendsShareACommonHobby(Hobby hobby);
}
