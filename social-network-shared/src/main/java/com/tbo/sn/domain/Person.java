package com.tbo.sn.domain;

import com.tbo.sn.constants.RelationshipType;
import com.tbo.sn.domain.occupation.Occupation;
import com.tbo.sn.domain.education.Education;
import com.tbo.sn.domain.hobby.Hobby;
import com.tbo.sn.domain.image.ProfileImage;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
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
    private Integer age;
    @Relationship(type = RelationshipType.PRIMARY_PROFILE_IMAGE, direction = Relationship.OUTGOING)
    private ProfileImage primaryProfileImage;
    @Relationship( type = RelationshipType.HOBBY, direction = Relationship.OUTGOING)
    private List<Hobby> hobbies;
    @Relationship(type = RelationshipType.FOLLOWING, direction = Relationship.INCOMING)
    private List<Person> followers;
    @Relationship(type = RelationshipType.FOLLOWING, direction = Relationship.OUTGOING)
    private List<Person> following;
    @Relationship(type = RelationshipType.OCCUPATION, direction = Relationship.OUTGOING)
    private Occupation primaryCareer;
    @Relationship(type = RelationshipType.EDUCATION, direction = Relationship.OUTGOING)
    private Education education;


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

    public Integer getAge()
    {
        return age;
    }

    public Person setAge( Integer age )
    {
        this.age = age;
        return this;
    }

    public ProfileImage getPrimaryProfileImage()
    {
        return primaryProfileImage;
    }

    public Person setPrimaryProfileImage( ProfileImage primaryProfileImage )
    {
        this.primaryProfileImage = primaryProfileImage;
        return this;
    }

    public List<Hobby> getHobbies()
    {
        return hobbies;
    }

    public Person setHobbies( List<Hobby> hobbies )
    {
        this.hobbies = hobbies;
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

    public Occupation getPrimaryCareer()
    {
        return primaryCareer;
    }

    public Person setPrimaryCareer( Occupation primaryCareer )
    {
        this.primaryCareer = primaryCareer;
        return this;
    }

    public Education getEducation()
    {
        return education;
    }

    public Person setEducation( Education education )
    {
        this.education = education;
        return this;
    }
}
