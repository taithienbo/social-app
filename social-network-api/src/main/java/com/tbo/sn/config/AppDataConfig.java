package com.tbo.sn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Configurations for interacting with the graph database.
 * @author tai
 * @since 3/17/18.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.tbo.sn.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "com.tbo.sn.domain")
public class AppDataConfig
{
    @Autowired
    private org.neo4j.ogm.config.Configuration configuration;

    @Bean
    public SessionFactory sessionFactory()
    {
        // with domain entity base package(s)
        return new SessionFactory( configuration, "com.tbo.sn.domain" );
    }

    @Bean
    public Session session()
    {
        return sessionFactory().openSession();
    }

    @Bean
    // we specify the profile here since for tests, we use an embedded database instead of connecting to a real one.
    @Profile( "!test" )
    public org.neo4j.ogm.config.Configuration configuration()
    {
        ConfigurationSource properties = new ClasspathConfigurationSource( "ogm.properties" );
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties)
                .build();
        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager()
    {
        return new Neo4jTransactionManager( sessionFactory() );
    }
}
