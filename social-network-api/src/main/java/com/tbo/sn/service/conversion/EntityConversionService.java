package com.tbo.sn.service.conversion;

import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import ma.glasnost.orika.metadata.Type;

/**
 * @author tai
 * @since 4/15/18.
 */
public interface EntityConversionService
{
    /**
     * Convert an object of type S to an object of type D.
     * @param source the source object to convert.
     * @param <D> the type of the target object.
     * @param <S> the type of the source object.
     * @param destinationType class type of the target object.
     * @return the target object.
     */
    <D, S> D convert( S source, Class<D> destinationType );


    /**
     * @see {@link MapperFacade#map(Object, Type, Type)}
     * @param source the source object.
     * @param typeSource the {@link Type} of the source.
     * @param typeTarget the {@link Type} of the result.
     * @param <D> The type parameter of the result.
     * @param <S> the type parameter of the source.
     * @return the result object.
     */
    <D, S> D convert( S source, Type<S> typeSource, Type<D> typeTarget);
}
