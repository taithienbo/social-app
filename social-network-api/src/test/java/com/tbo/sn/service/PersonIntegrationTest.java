package com.tbo.sn.service;

import com.tbo.sn.config.AppIntegrationTest;
import com.tbo.sn.constants.EducationAchievementField;
import com.tbo.sn.constants.EducationAchievementType;
import com.tbo.sn.dod.PersonDataOnDemand;
import com.tbo.sn.domain.node.Badminton;
import com.tbo.sn.domain.node.EducationAchievement;
import com.tbo.sn.domain.node.Hobby;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.domain.node.School;
import com.tbo.sn.domain.node.Soccer;
import com.tbo.sn.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
/**
 *
 * @author tai
 * @since 3/24/18.
 */
public class PersonIntegrationTest extends AppIntegrationTest<Person,PersonRepository, PersonService,PersonDataOnDemand>
{
    @Override
    @Autowired
    public void setRepository( PersonRepository repository )
    {
        super.setRepository( repository );
    }

    @Override
    @Autowired
    public void setService( PersonService service )
    {
        super.setService( service );
    }

    @Override
    @Autowired
    public void setDataOnDemand( PersonDataOnDemand dataOnDemand )
    {
        super.setDataOnDemand( dataOnDemand );
    }

    /**
     * @see PersonService#findPeopleByDobBetween(Date, Date)
     */
    @Test
    public void findPeopleByAgeBetween()
    {
        // we are interested in finding young adults in the range of eighteen to 30 years old.
        // generate test data
        Iterator<Person> peopleIterator  = getDataOnDemand().getManyNewPersisted(6).iterator();
        List<Person> expectedResultList = new ArrayList<>(  );
        Calendar today = Calendar.getInstance();
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.clear();
        toCalendar.set(today.get(Calendar.YEAR) - 18, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)      );
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.clear();
        fromCalendar.set(today.get(Calendar.YEAR) - 30, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));

        // ensure we have at least one Person between 18 and 30 years old for test.
        do {
            Person person = peopleIterator.next();
            Calendar dob = Calendar.getInstance();
            dob.clear();
            dob.set(today.get(Calendar.YEAR) - (Math.max(18, getEnhancedRandom().nextInt(30))),
                    today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)      );
            person.setDob( dob.getTime() );
            person = getService().save(person);
            expectedResultList.add(person);
        } while ( peopleIterator.hasNext() && getEnhancedRandom().nextBoolean());

        // retrieve
        List<Person> peopleBetween18And30YearsOld = getService().findPeopleByDobBetween( fromCalendar.getTime(),
                toCalendar.getTime() );
        // verify
        assertThat( "Result of people between 18 and 30 years old should not be null.",
                peopleBetween18And30YearsOld,
                notNullValue() );
        assertThat( "List of peopleBetween18And30YearsOld is not correct.",
                peopleBetween18And30YearsOld
                , equalTo( expectedResultList ));
    }

    /**
     * @see PersonService#findPeopleByGender(String)
     */
    @Test
    public void findPeopleByGender()
    {
        // generate test data
        int numOfExpectedResults = 0;
        String gender = "Female";
        List<Person> people = getDataOnDemand().getManyNewPersisted( 10 );
        for ( int i = 0; i < people.size(); i++ ) {
            if ( i % 2 == 0 ) {
                people.get(i).setGender( gender );
                getService().save(people.get(i));
                numOfExpectedResults++;
            }
        }
        List<Person> peopleByGender = getService().findPeopleByGender( gender );
        assertThat("List of peopleByGender cannot be null.", peopleByGender, notNullValue());
        assertThat("Size of peopleByGender list is not correct.", peopleByGender.size(), equalTo(
                numOfExpectedResults ));

    }

    /**
     * @see PersonService#findPeopleToFollow(Long)
     */
    @Test
    public void findPeopleToFollow()
    {
        // setup test data
        // A group of people who attended the same school and share the same hobby.
        School school = new School().setName( "University of California, Irvine." );
        List<Hobby> hobbies = Lists.newArrayList(new Badminton().setDescription( "A fun sport" ),
                new Soccer().setDescription( "A great and fun sport that promotes team work." ));
        List<Person> people = getDataOnDemand().getManyNewTransient( 5 );
        for ( Person person : people )
        {
            person.setAttenedSchoolCollection( Lists.newArrayList(school) );
            person.setHobbies( hobbies );
            person = getService().save(person);
        }
        Person person = people.get(0);
        // find the other people who also went to UCI and have Badminton and Soccer as hobbies.
        List<Person> peopleToFollow = Lists.newArrayList(getService().findPeopleToFollow( person.getId() ) );
        assertThat("PeopleToFollow list should not be null.", peopleToFollow, notNullValue());
        assertThat( "Size of peopleToFollow list is not correct.", peopleToFollow.size(), equalTo( people.size() -
                1 ));
    }
}
