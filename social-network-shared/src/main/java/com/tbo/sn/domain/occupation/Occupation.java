package com.tbo.sn.domain.occupation;

import com.tbo.sn.domain.Entity;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author tai
 * @since 3/17/18.
 */
@NodeEntity
public class Occupation extends Entity
{
    private String name;
}
