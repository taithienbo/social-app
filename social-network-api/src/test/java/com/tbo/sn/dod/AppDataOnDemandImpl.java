package com.tbo.sn.dod;

import com.google.common.collect.Lists;
import com.tbo.sn.domain.Entity;
import com.tbo.sn.repository.AppRepository;
import com.tbo.sn.service.AppService;
import com.tbo.sn.util.ReflectionUtil;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Base implementation for generating different entity objects, utilizing {@link EnhancedRandom}.
 * @author tai
 * @since 3/24/18.
 */
public class AppDataOnDemandImpl<T extends Entity, R extends AppRepository<T>, S extends AppService<T, R>> implements
        AppDataOnDemand<T, R, S>
{

    private R repository;
    private S service;

    public AppDataOnDemandImpl(R repository, S service)
    {
        this.service = service;
        this.repository = repository;
    }

    @Override
    public T getNewTransient()
    {
        T entity = getEnhancedRandomBuilder().build().nextObject( service.getDomainType(), getExcludedFields()
                .toArray(new
                String[getExcludedFields().size()]));
        return entity;
    }

    @Override
    public T getNewPersisted()
    {
        return getService().save(getNewTransient());
    }

    @Override
    public List getManyNewTransient()
    {
        int count = Math.max(2, getEnhancedRandomBuilder().build().nextInt(5));
        return ( getManyNewTransient( count ) );
    }

    @Override
    public List<T> getManyNewTransient( int count )
    {
        List<T> entities = new ArrayList<>(  );
        for (int i = 0; i < count; i++)
        {
            entities.add( getNewTransient() );
        }
        return entities;
    }

    @Override
    public List<T> getManyNewPersisted()
    {
        return Lists.newArrayList(getService().saveAll(getManyNewTransient()));
    }

    @Override
    public List<T> getManyNewPersisted( int count )
    {
        List<T> entities = new ArrayList<>(  );
        for (int i = 0; i < count; i++)
        {
            entities.add(getNewTransient());
        }

        return Lists.newArrayList( getService().saveAll(entities) );
    }

    @Override
    public List<String> getExcludedFields()
    {
        return Lists.newArrayList(ReflectionUtil.getIdField( getService().getDomainType() ).getName());
    }

    @Override
    public R getRepository()
    {
        return repository;
    }

    @Override
    public S getService()
    {
        return service;
    }

    @Override
    public EnhancedRandomBuilder getEnhancedRandomBuilder()
    {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder().exclude( Collection
                .class ).exclude( List.class );

    }
}
