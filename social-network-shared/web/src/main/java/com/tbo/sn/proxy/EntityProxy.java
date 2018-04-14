package com.tbo.sn.proxy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tbo.sn.domain.Entity;

import java.io.Serializable;

/**
 * Modeling a json payload containing {@link Entity} data.
 * @author tai
 * @since 4/21/18.
 */
@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
public class EntityProxy implements Serializable
{
    private Long id;

    public Long getId()
    {
        return id;
    }

    public EntityProxy setId( Long id )
    {
        this.id = id;
        return this;
    }
}
