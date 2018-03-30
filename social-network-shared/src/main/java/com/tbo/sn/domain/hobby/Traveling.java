package com.tbo.sn.domain.hobby;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * @author tai
 * @since 3/17/18.
 */
public class Traveling
{
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String companyName;

    public Long getId()
    {
        return id;
    }

    public Traveling setId( Long id )
    {
        this.id = id;
        return this;
    }

    public String getTitle()
    {
        return title;
    }

    public Traveling setTitle( String title )
    {
        this.title = title;
        return this;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public Traveling setCompanyName( String companyName )
    {
        this.companyName = companyName;
        return this;
    }
}
