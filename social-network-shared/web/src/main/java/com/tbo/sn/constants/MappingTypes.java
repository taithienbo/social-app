package com.tbo.sn.constants;

import com.tbo.sn.domain.node.Person;
import com.tbo.sn.proxy.PersonProxy;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * @author tai
 * @since 4/16/18.
 */
public class MappingTypes
{
    public static final Type<Page<Person>> PAGE_RESULT_PERSON = new TypeBuilder<Page<Person>>(){}.build();
    public static final Type<Page<PersonProxy>> PAGE_RESULT_PERSON_PROXY = new TypeBuilder<Page< PersonProxy>>(){}
    .build();
}
