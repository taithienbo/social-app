package com.tbo.sn.service.conversion;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.metadata.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author tai
 * @since 4/16/18.
 */
@Service
public class EntityConversionServiceImpl implements EntityConversionService
{
    private MapperFacade mapperFacade;

    @Autowired
    public EntityConversionServiceImpl( MapperFacade mapperFacade )
    {
        this.mapperFacade = mapperFacade;
    }

    @Override
    public <D, S> D convert( S source, Class<D> destinationType )
    {
        return mapperFacade.map( source, destinationType);
    }

    @Override
    public <D, S> D convert( S source, Type<S> typeSource, Type<D> typeDestination )
    {
        return mapperFacade.map(source, typeSource, typeDestination);
    }


}
