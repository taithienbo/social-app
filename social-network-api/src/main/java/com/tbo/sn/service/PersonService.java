package com.tbo.sn.service;

import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.domain.Person;
import com.tbo.sn.domain.education.Education;
import com.tbo.sn.domain.hobby.Hobby;

import java.util.List;

/**
 * Data capabilities on or relating to a {@link Person}
 * @author tai
 * @since 3/24/18.
 */
public interface PersonService extends AppService<Person,PersonRepository>
{
    List<Person> findPeopleByEducation(Education education);
    List<Person> findPeopleByAgeBetween(int startAge, int endAge);
    List<Person> findPeopleByGender(String gender);
    List<Person> findFriendsOfFriendsShareACommonHobby(Hobby hobby);
}
