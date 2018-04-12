package com.tbo.sn.domain.node;

import com.tbo.sn.domain.Entity;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author tai
 * @since 4/3/18.
 */
@NodeEntity
public interface Hobby
{
    String getDescription();
}
