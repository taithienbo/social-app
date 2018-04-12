package com.tbo.sn.service;

import com.tbo.sn.domain.node.Hobby;
import com.tbo.sn.domain.node.School;
import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.domain.node.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author tai
 * @since 3/24/18.
 */
@Service
@Transactional
public class PersonServiceImpl extends AppServiceImpl<Person,PersonRepository> implements PersonService
{
    public PersonServiceImpl( PersonRepository repository )
    {
        super( Person.class, repository );
    }

    @Override
    public List<Person> findPeopleByGender(String gender)
    {
        return getRepository().findPeopleByGender( gender );
    }

    @Override
    public List<Person> findPeopleByDobBetween( Date from, Date to )
    {
        return getRepository().findPeopleByDobBetween( from, to );
    }

    @Override
    public Iterable<Person> findPeopleToFollow( Long personId )
    {
        return getRepository().findPeopleWhoAttendSameSchoolAndShareSameHobbyToFollow( personId );
    }


}
