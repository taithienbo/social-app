package com.tbo.sn;

import com.google.common.collect.ImmutableMap;
import com.tbo.sn.config.AppIntegrationTest;
import com.tbo.sn.constants.Gender;
import com.tbo.sn.dod.PersonDataOnDemand;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.proxy.PersonProxy;
import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Tests for {@link PersonControllerImpl}
 * @author tai
 * @since 4/21/18.
 */
public class PersonControllerTest extends AppIntegrationTest<Person,PersonRepository,PersonService,PersonDataOnDemand>
{
    @Autowired
    private PersonController personController;

    @Autowired
    @Override
    public void setRepository( PersonRepository repository )
    {
        super.setRepository( repository );
    }

    @Autowired
    @Override
    public void setService( PersonService service )
    {
        super.setService( service );
    }

    @Autowired
    @Override
    public void setDataOnDemand( PersonDataOnDemand dataOnDemand )
    {
        super.setDataOnDemand( dataOnDemand );
    }

    /**
     * @see {@link PersonController#findPeopleByGenderAndAgeBetween(String, Integer, Integer, int, int)}
     */
    @Test
    public void findPeopleByGenderAndAgeBetween()
    {
        List<Person> people = getDataOnDemand().getManyNewTransient();

        // create men between 20 and 30 years old.
        final int ageStart = 20;
        final int ageEnd = 30;
        final Gender gender = Gender.MALE;
        for ( Person person : people )
        {
            person.setGender( gender.getGender() );
            Calendar dob = Calendar.getInstance();
            dob.set( Calendar.YEAR, dob.get( Calendar.YEAR) - (ageStart + getEnhancedRandom()
                    .nextInt( ageEnd - ageStart )));
            person.setDob( dob.getTime() );
            getService().save( person );
        }
        Page<PersonProxy> pageResult = personController.findPeopleByGenderAndAgeBetween( gender.getGender(),
                ageStart, ageEnd, 0, people.size()  );
        assertThat( "PageResult should not be null.", pageResult, notNullValue() );
        assertThat( "Number of result is not correct.", pageResult.getNumberOfElements(), equalTo( people.size() ));
        for ( PersonProxy personProxy : pageResult )
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
