package com.tbo.sn.domain.education;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author tai
 * @since 3/17/18.
 */
@NodeEntity
public class Education
{
    @Id
    @GeneratedValue
    private Long id;

    private String school;
    private Date yearStarted;
    private Date yearEnded;
    private Boolean graduated;

    public Long getId()
    {
        return id;
    }

    public Education setId( Long id )
    {
        this.id = id;
        return this;
    }

    public String getSchool()
    {
        return school;
    }

    public Education setSchool( String school )
    {
        this.school = school;
        return this;
    }

    public Date getYearStarted()
    {
        return yearStarted;
    }

    public Education setYearStarted( Date yearStarted )
    {
        this.yearStarted = yearStarted;
        return this;
    }

    public Date getYearEnded()
    {
        return yearEnded;
    }

    public Education setYearEnded( Date yearEnded )
    {
        this.yearEnded = yearEnded;
        return this;
    }

    public Boolean getGraduated()
    {
        return graduated;
    }

    public Education setGraduated( Boolean graduated )
    {
        this.graduated = graduated;
        return this;
    }
}
