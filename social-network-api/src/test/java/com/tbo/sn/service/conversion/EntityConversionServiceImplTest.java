package com.tbo.sn.service.conversion;

import com.google.common.collect.ImmutableMap;
import com.tbo.sn.AppTest;
import com.tbo.sn.constants.MappingTypes;
import com.tbo.sn.dod.PersonDataOnDemand;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.proxy.PersonProxy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import java.util.Map;

/**
 * @author tai
 * @since 4/21/18.
 *
 * Tests for {@link EntityConversionServiceImpl}
 */
public class EntityConversionServiceImplTest extends AppTest
{
    @Autowired
    private EntityConversionService ecs;

    @Autowired
    private PersonDataOnDemand personDataOnDemand;

    @Test
    public void convertPersonToPersonProxy()
    {
        Person person = personDataOnDemand.getNewPersisted();
        PersonProxy personProxy = ecs.convert( person, PersonProxy.class );
        Map<String, Object> notNullFields = ImmutableMap.of( "Id", personProxy.getId(), "Dob", personProxy.getDob
            (), "Email", personProxy.getEmail(), "FirstName", personProxy.getFirstName(), "LastName", personProxy
                        .getLastName());
        for ( String key : notNullFields.keySet() )
        {
            assertThat("%s cannot be null.".format( key), notNullFields.get(key), notNullValue());
        }
    }

    @Test
    public void convertPageResultPersonToPageResultPersonProxy()
    {
        List<Person> people = personDataOnDemand.getManyNewPersisted();
        Page<Person> pageResult = new PageImpl<>( people );
        Page<PersonProxy> pageResultProxy = ecs.convert( pageResult, MappingTypes.PAGE_RESULT_PERSON,
                MappingTypes.PAGE_RESULT_PERSON_PROXY );
        assertThat( "PageResult should not be null", pageResultProxy, notNullValue());
        assertThat( "Number of result is not correct.", pageResultProxy.getSize(), equalTo( people.size() ));
        for ( PersonProxy personProxy : pageResultProxy )
        {
            Map<String, Object> notNullFields = ImmutableMap.of( "Id", personProxy.getId(), "Dob", personProxy.getDob
                    (), "Email", personProxy.getEmail(), "FirstName", personProxy.getFirstName(), "LastName", personProxy
                    .getLastName());
            for ( String key : notNullFields.keySet())
            {
                assertThat("%s cannot be null.".format( key), notNullFields.get(key), notNullValue());
            }
        }


    }
}
