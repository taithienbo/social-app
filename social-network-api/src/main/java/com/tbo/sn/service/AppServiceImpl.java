package com.tbo.sn.service;

import com.tbo.sn.domain.Entity;
import com.tbo.sn.repository.AppRepository;

/**
 * @author tai
 * @since 3/24/18.
 */
public class AppServiceImpl<T extends Entity, R extends AppRepository<T>> implements AppService<T, R>
{
    protected Class<T> domainType;
    protected R repository;

    public AppServiceImpl(Class<T> domainType, R repository)
    {
        this.domainType = domainType;
        this.repository = repository;
    }

    @Override
    public Class<T> getDomainType()
    {
        return domainType;
    }

    @Override
    public R getRepository()
    {
        return repository;
    }

    @Override
    public T save( T entity )
    {
        return getRepository().save(entity);
    }

    @Override
    public Iterable<T> saveAll( Iterable<T> entities )
    {
        return getRepository().saveAll(entities);
    }

    @Override
    public void deleteAll()
    {
        repository.deleteAll();
    }
}
