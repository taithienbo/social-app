package com.tbo.sn.dod;

import com.tbo.sn.domain.node.EducationAchievement;
import com.tbo.sn.domain.node.Hobby;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.domain.node.School;
import com.tbo.sn.repository.PersonRepository;
import com.tbo.sn.service.PersonService;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        enhancedRandomBuilder.exclude(
                FieldDefinitionBuilder.field().ofType( School.class ).get() )
                .exclude( FieldDefinitionBuilder.field().ofType( Hobby.class ).get() ).exclude(
                        FieldDefinitionBuilder.field().ofType( EducationAchievement.class ).get() );
        return enhancedRandomBuilder;
    }
}
