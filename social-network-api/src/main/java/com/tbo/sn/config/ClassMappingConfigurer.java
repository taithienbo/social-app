package com.tbo.sn.config;

import com.tbo.sn.constants.MappingTypes;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.proxy.PersonProxy;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.MapperFacadeImpl;
import ma.glasnost.orika.metadata.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * @author tai
 * @since 4/15/18.
 */
@Configuration
public class ClassMappingConfigurer
{
    @Bean
    public MapperFacade mapperFacade()
    {
        return mapperFactory().getMapperFacade();
    }

    @Bean
    public MapperFactory mapperFactory()
    {
        MapperFactory factory = new DefaultMapperFactory.Builder().useAutoMapping( true ).build();
        configureFactory(factory);
        return factory;
    }

    private void configureFactory( MapperFactory factory )
    {
        factory.classMap( Person.class, PersonProxy.class ).byDefault(  ).register();
        factory.getConverterFactory().registerConverter( new CustomConverter<Page<Person>, Page<PersonProxy>>()
        {
            @Override
            public boolean canConvert( Type<?> sourceType, Type<?> destinationType )
            {
                return sourceType.equals( MappingTypes.PAGE_RESULT_PERSON) &&
                        destinationType.equals( MappingTypes.PAGE_RESULT_PERSON_PROXY );
            }

            @Override
            public Page<PersonProxy> convert( Page<Person> source, Type<? extends Page<PersonProxy>> destinationType,
                    MappingContext mappingContext )
            {
                PageImpl<PersonProxy> personProxyPage = new PageImpl<>( mapperFacade.mapAsList( source.getContent(),
                        PersonProxy.class ), PageRequest.of(0, source.getNumberOfElements()), source.getTotalElements());
                return personProxyPage;
            }
        } );
    }


}
