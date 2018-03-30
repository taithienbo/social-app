package com.tbo.sn.config;

import com.tbo.sn.AppTest;
import com.tbo.sn.dod.AppDataOnDemand;
import com.tbo.sn.domain.Entity;
import com.tbo.sn.repository.AppRepository;
import com.tbo.sn.service.AppService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;


import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
/**
 * @author tai
 * @since 3/24/18.
 */
@ActiveProfiles("test")
public abstract class AppIntegrationTest<T extends Entity, R extends AppRepository<T>, S extends AppService<T,R>, D
        extends
        AppDataOnDemand<T, R, S>> extends AppTest
{
    private R repository;
    private S service;
    private D dataOnDemand;

    public void setRepository( R repository )
    {
        this.repository = repository;
    }

    public void setService( S service )
    {
        this.service = service;
    }

    public void setDataOnDemand( D dataOnDemand )
    {
        this.dataOnDemand = dataOnDemand;
    }

    @Test
    public void save()
    {
        T entity = dataOnDemand.getNewTransient();
        entity = service.save( entity );
        assertThat( entity.getId(), notNullValue());
    }
}
