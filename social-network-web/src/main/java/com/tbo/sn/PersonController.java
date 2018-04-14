package com.tbo.sn;

import com.tbo.sn.proxy.PersonProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author tai
 * @since 4/14/18.
 */
public interface PersonController
{
    /**
     * Find people by gender and age.
     * @param ageRangeStart for limiting result by age less than or equal to the given ageRangeStart.
     * @param ageRangeEnd for limiting result by age greater than or equal to the given ageRangeEnd.
     * @param gender for limiting result by gender.
     * @param page the page number for pagination
     * @param size number of results per page for pagination.
     * @return a page result of {@link PersonProxy} objects.
     */
    Page<PersonProxy> findPeopleByGenderAndAgeBetween( String gender, Integer ageRangeStart, Integer ageRangeEnd,
            int page, int size);
}
