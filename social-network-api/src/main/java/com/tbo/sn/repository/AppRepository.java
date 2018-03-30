package com.tbo.sn.repository;

import com.tbo.sn.domain.Entity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author tai
 * @since 3/24/18.
 */
@NoRepositoryBean
public interface AppRepository<T extends Entity> extends Neo4jRepository<T, Long>
{
}
