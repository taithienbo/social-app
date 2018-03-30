package com.tbo.sn.config;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Configurations to start up an embedded neo4j database for tests.
 * @author tai
 * @since 3/24/18.
 */
@org.springframework.context.annotation.Configuration
@Profile( "test" )
public class AppTestDataConfig
{

    /**
     * Configuration for embedded database.
     * @return
     */
    @Bean
    public Configuration configuration()
    {
        // The neo4j-ogm uses the embedded driver by default if we don't specify a url to the database.
        Configuration configuration = new Configuration.Builder(  ).build();
        return configuration;
    }
}
