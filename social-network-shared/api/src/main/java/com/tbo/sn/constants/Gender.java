package com.tbo.sn.constants;

/**
 * @author tai
 * @since 4/14/18.
 */
public enum Gender
{
    MALE("Male"),
    FEMALE("Female");

    private String gender;

    Gender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }

    public Gender setGender( String gender )
    {
        this.gender = gender;
        return this;
    }
}
