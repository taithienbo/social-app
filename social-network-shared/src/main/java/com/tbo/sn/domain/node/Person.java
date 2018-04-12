package com.tbo.sn.domain.node;

import com.tbo.sn.constants.RelationshipType;
import com.tbo.sn.domain.Entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author tai
 * @since 3/17/18.
 */
@NodeEntity
public class Person extends Entity
{
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String username;
    private String email;
    private Date dob;

    private List<Person> followers;
    @Relationship(type = RelationshipType.FOLLOWING, direction = Relationship.OUTGOING)
    private List<Person> following;
    @Relationship(type = RelationshipType.ATTENDED_SCHOOL, direction = Relationship.OUTGOING)
    private Collection<School> attenedSchoolCollection;
    private Collection<EducationAchievement> educationAchievementCollection;
    @Relationship(type = RelationshipType.HOBBY, direction = Relationship.OUTGOING)
    private Collection<Hobby> hobbies;

    public String getFirstName()
    {
        return firstName;
    }

    public Person setFirstName( String firstName )
    {
        this.firstName = firstName;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Person setLastName( String lastName )
    {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public Person setMiddleName( String middleName )
    {
        this.middleName = middleName;
        return this;
    }

    public String getGender()
    {
        return gender;
    }

    public Person setGender( String gender )
    {
        this.gender = gender;
        return this;
    }

    public Date getDob()
    {
        return dob;
    }

    public Person setDob( Date dob )
    {
        this.dob = dob;
        return this;
    }

    public List<Person> getFollowers()
    {
        return followers;
    }

    public Person setFollowers( List<Person> followers )
    {
        this.followers = followers;
        return this;
    }

    public List<Person> getFollowing()
    {
        return following;
    }

    public Person setFollowing( List<Person> following )
    {
        this.following = following;
        return this;
    }

    public String getUsername()
    {
        return username;
    }

    public Person setUsername( String username )
    {
        this.username = username;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public Person setEmail( String email )
    {
        this.email = email;
        return this;
    }

    public Collection<School> getAttenedSchoolCollection()
    {
        return attenedSchoolCollection;
    }

    public Person setAttenedSchoolCollection( Collection<School> attenedSchoolCollection )
    {
        this.attenedSchoolCollection = attenedSchoolCollection;
        return this;
    }

    public Collection<EducationAchievement> getEducationAchievementCollection()
    {
        return educationAchievementCollection;
    }

    public Person setEducationAchievementCollection(
            Collection<EducationAchievement> educationAchievementCollection )
    {
        this.educationAchievementCollection = educationAchievementCollection;
        return this;
    }

    public Collection<Hobby> getHobbies()
    {
        return hobbies;
    }

    public Person setHobbies( Collection<Hobby> hobbies )
    {
        this.hobbies = hobbies;
        return this;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals( firstName, person.firstName ) &&
                Objects.equals( lastName, person.lastName ) &&
                Objects.equals( middleName, person.middleName ) &&
                Objects.equals( gender, person.gender ) &&
                Objects.equals( username, person.username ) &&
                Objects.equals( email, person.email ) &&
                Objects.equals( dob, person.dob );
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( firstName, lastName, middleName, gender, username, email, dob );
    }
}
