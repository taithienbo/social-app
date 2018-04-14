package com.tbo.sn.proxy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tbo.sn.domain.node.Person;

import java.io.Serializable;
import java.util.Date;

/**
 * Payload representation of a {@link Person}
 * @author tai
 * @since 4/14/18.
 */
@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL)
public class PersonProxy extends EntityProxy
{
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String username;
    private String email;
    private Date dob;

    public String getFirstName()
    {
        return firstName;
    }

    public PersonProxy setFirstName( String firstName )
    {
        this.firstName = firstName;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public PersonProxy setLastName( String lastName )
    {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public PersonProxy setMiddleName( String middleName )
    {
        this.middleName = middleName;
        return this;
    }

    public String getGender()
    {
        return gender;
    }

    public PersonProxy setGender( String gender )
    {
        this.gender = gender;
        return this;
    }

    public String getUsername()
    {
        return username;
    }

    public PersonProxy setUsername( String username )
    {
        this.username = username;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public PersonProxy setEmail( String email )
    {
        this.email = email;
        return this;
    }

    public Date getDob()
    {
        return dob;
    }

    public PersonProxy setDob( Date dob )
    {
        this.dob = dob;
        return this;
    }


}
