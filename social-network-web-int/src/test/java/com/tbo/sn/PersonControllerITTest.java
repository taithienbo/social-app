package com.tbo.sn;


import com.google.common.collect.ImmutableMap;
import com.tbo.sn.constants.Gender;
import com.tbo.sn.dod.PersonDataOnDemand;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.proxy.PersonProxy;
import com.tbo.sn.support.PageProxy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Integration tests for {@link PersonController} endpoints
 * @author tai
 * @since 4/21/18.
 */
public class PersonControllerITTest extends ITTest
{
   @Autowired
   private TestRestTemplate testRestTemplate;

   @Autowired
   private PersonDataOnDemand personDataOnDemand;

    /**
     * @see PersonController#findPeopleByGenderAndAgeBetween(String, Integer, Integer, int, int)
     */
    @Test

    public void findPeopleByGenderAndAgeBetween()
    {
        List<Person> people = personDataOnDemand.getManyNewTransient();

        // create women between 20 and 30 years old.
        final int ageStart = 20;
        final int ageEnd = 30;
        final Gender gender = Gender.FEMALE;
        for ( Person person : people )
        {
            person.setGender( gender.getGender() );
            Calendar dob = Calendar.getInstance();
            dob.set( Calendar.YEAR, dob.get( Calendar.YEAR) - (ageStart + personDataOnDemand.getEnhancedRandomBuilder
                    ().build()
                    .nextInt( ageEnd - ageStart )));
            person.setDob( dob.getTime() );
            personDataOnDemand.getService().save( person );
        }
        String url = "/person?gender={gender}&ageStart={ageStart}&ageEnd={ageEnd}&page={page}&size={size}";
        Map<String, String> queryParams = ImmutableMap.<String, String>builder()
                .put("gender", gender.getGender())
                .put( "ageStart", Integer.toString(ageStart))
                .put("ageEnd", Integer.toString( ageEnd ))
                .put("page", Integer.toString(0))
                .put("size", Integer.toString(people.size())).build();
        ResponseEntity<PageProxy<PersonProxy>> jsonResponse = testRestTemplate.exchange( url, HttpMethod.GET, null,
                new ParameterizedTypeReference<PageProxy<PersonProxy>>()
                {
                }, queryParams );
        assertThat( "Request failed.", jsonResponse.getStatusCodeValue(), equalTo( HttpStatus.OK.value() ));
        PageProxy<PersonProxy> pageProxyResult = jsonResponse.getBody();
        assertThat( "Page proxy result should not be null.", pageProxyResult, notNullValue());
        assertThat("Number of result is not correct.", pageProxyResult.getTotalElements(), equalTo(
                Long.valueOf(people.size() )));
        for ( PersonProxy personProxy : pageProxyResult.getContent())
        {
            assertThat("Id should not be null.", personProxy.getId(), notNullValue());
        }


    }
}
