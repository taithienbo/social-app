package com.tbo.sn.service;

import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.domain.Person;
import com.tbo.sn.domain.education.Education;
import com.tbo.sn.domain.hobby.Hobby;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Person> findPeopleByEducation( Education education )
    {
        return getRepository().findPeopleByEducation( education );
    }

    @Override
    public List<Person> findPeopleByAgeBetween(int startAge, int endAge)
    {
        return getRepository().findPeopleByAgeBetween( startAge, endAge );
    }

    @Override
    public List<Person> findPeopleByGender(String gender)
    {
        return getRepository().findPeopleByGender( gender );
    }

    @Override
    public List<Person> findFriendsOfFriendsShareACommonHobby(Hobby hobby)
    {
        return getRepository().findFriendsOfFriendsShareACommonHobby( hobby );
    }
}
