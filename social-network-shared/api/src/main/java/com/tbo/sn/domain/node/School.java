package com.tbo.sn.domain.node;

import com.tbo.sn.domain.Entity;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author tai
 * @since 3/17/18.
 */
@NodeEntity
public class School extends Entity
{
    private String name;

    public String getName()
    {
        return name;
    }

    public School setName( String name )
    {
        this.name = name;
        return this;
    }
}
