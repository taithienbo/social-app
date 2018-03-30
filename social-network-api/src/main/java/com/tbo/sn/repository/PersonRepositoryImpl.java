package com.tbo.sn.repository;

import com.tbo.sn.domain.Person;
import com.tbo.sn.domain.education.Education;
import com.tbo.sn.domain.hobby.Hobby;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tai
 * @since 3/17/18.
 */
public class PersonRepositoryImpl implements PersonRepositoryExt
{

    @Override
    public List<Person> findPeopleToFollowByEducationAndHobbies( List<Education> educationList, List<Hobby> hobbyList )
    {
        return null;
    }

    @Override
    public List<Person> findFriendsOfFriendsShareACommonHobby( Hobby hobby )
    {
        return null;
    }
}
