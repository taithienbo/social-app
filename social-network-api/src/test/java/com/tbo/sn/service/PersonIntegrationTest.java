package com.tbo.sn.service;

import com.tbo.sn.config.AppIntegrationTest;
import com.tbo.sn.dod.AppDataOnDemand;
import com.tbo.sn.dod.PersonDataOnDemand;
import com.tbo.sn.domain.Person;
import com.tbo.sn.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
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

}
