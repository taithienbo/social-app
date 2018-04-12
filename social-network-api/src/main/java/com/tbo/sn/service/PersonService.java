package com.tbo.sn.service;

import com.tbo.sn.domain.node.Hobby;
import com.tbo.sn.domain.node.School;
import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.domain.node.Person;

import java.util.Date;
import java.util.List;

/**
 * Data capabilities on or relating to a {@link Person}
 * @author tai
 * @since 3/24/18.
 */
public interface PersonService extends AppService<Person,PersonRepository>
{
    List<Person> findPeopleByGender(String gender);
    List<Person> findPeopleByDobBetween( Date from, Date to);
    Iterable<Person> findPeopleToFollow( Long personId );
}
