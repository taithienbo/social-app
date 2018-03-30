package com.tbo.sn.service;

import com.tbo.sn.domain.Entity;
import com.tbo.sn.repository.AppRepository;

import java.util.Collection;
import java.util.List;

/**
 * Common data capabilities across all domain types.
 * @author tai
 * @since 3/24/18.
 */
public interface AppService<T extends Entity, R extends AppRepository<T>>
{
    Class<T> getDomainType();
    R getRepository();
    T save( T entity );
    Iterable<T> saveAll(Iterable<T> entities) ;
}
