package com.tbo.sn.dod;

import com.tbo.sn.domain.Entity;
import com.tbo.sn.repository.AppRepository;
import com.tbo.sn.service.AppService;
import io.github.benas.randombeans.EnhancedRandomBuilder;

import java.util.List;

/**
 * Contract for generating factual data to use in tests.
 * @author tai
 * @since 3/24/18.
 */
public interface AppDataOnDemand<T extends Entity, R extends AppRepository<T>, S extends AppService<T, R>>
{
    T getNewTransient();
    T getNewPersisted();
    Iterable<T> getManyNewTransient();
    Iterable<T> getManyNewPersisted();
    List<String> getExcludedFields();
    R getRepository();
    S getService();

    EnhancedRandomBuilder getEnhancedRandomBuilder();
}
