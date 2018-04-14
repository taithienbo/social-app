package com.tbo.sn;

import com.tbo.sn.constants.MappingTypes;
import com.tbo.sn.domain.node.Person;
import com.tbo.sn.proxy.PersonProxy;
import com.tbo.sn.service.PersonService;
import com.tbo.sn.service.conversion.EntityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tai
 * @since 4/14/18.
 */
@RestController
@RequestMapping("/person")
public class PersonControllerImpl implements PersonController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private EntityConversionService ecs;

    @GetMapping
    @Override
    public Page<PersonProxy> findPeopleByGenderAndAgeBetween( @RequestParam("gender") String gender, @RequestParam
            ("ageStart") Integer ageRangeStart, @RequestParam("ageEnd") Integer ageRangeEnd, @RequestParam("page") int
            page, @RequestParam("size") int size )
    {
        Page<Person> pageResult = personService.findPeopleByGenderAndAgeBetween( gender, ageRangeStart, ageRangeEnd,
            PageRequest.of( page, size) );
        Page<PersonProxy> proxyPageResult = ecs.convert( pageResult, MappingTypes.PAGE_RESULT_PERSON, MappingTypes
                .PAGE_RESULT_PERSON_PROXY );
        return proxyPageResult;
    }
}
