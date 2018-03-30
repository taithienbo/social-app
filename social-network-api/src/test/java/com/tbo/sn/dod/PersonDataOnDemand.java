package com.tbo.sn.dod;

import com.tbo.sn.domain.Person;
import com.tbo.sn.domain.education.Education;
import com.tbo.sn.domain.image.ProfileImage;
import com.tbo.sn.domain.occupation.Occupation;
import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.service.PersonService;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tai
 * @since 3/27/18.
 */
@Service
public class PersonDataOnDemand extends AppDataOnDemandImpl<Person,PersonRepository,PersonService>
        implements AppDataOnDemand<Person, PersonRepository, PersonService>
{
    @Autowired
    public PersonDataOnDemand( PersonRepository repository, PersonService service )
    {
        super( repository, service );
    }

    @Override
    public EnhancedRandomBuilder getEnhancedRandomBuilder()
    {
        EnhancedRandomBuilder enhancedRandomBuilder =  super.getEnhancedRandomBuilder();
        enhancedRandomBuilder.exclude( FieldDefinitionBuilder.field().ofType( ProfileImage.class ).get() ).exclude(
                FieldDefinitionBuilder.field().ofType( Education.class ).get() ).exclude( FieldDefinitionBuilder
                .field().ofType( Occupation.class ).get() );
        return enhancedRandomBuilder;
    }
}
