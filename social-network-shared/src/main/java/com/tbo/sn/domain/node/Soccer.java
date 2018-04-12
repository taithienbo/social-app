package com.tbo.sn.domain.node;

import com.tbo.sn.domain.Entity;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author tai
 * @since 4/4/18.
 */
@NodeEntity
public class Soccer extends Entity implements Hobby, Sport
{
    private String description;

    @Override
    public String getDescription()
    {
        return description;
    }

    public Soccer setDescription( String description )
    {
        this.description = description;
        return this;
    }
}
