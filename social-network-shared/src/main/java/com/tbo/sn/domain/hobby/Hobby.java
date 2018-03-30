package com.tbo.sn.domain.hobby;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author tai
 * @since 3/17/18.
 */
@NodeEntity
public class Hobby
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;


}
