package com.tbo.sn.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * Base class for declaring common properties between different entities.
 * @author tai
 * @since 3/28/18.
 */
public class Entity
{
    @Id
    @GeneratedValue
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }
}
