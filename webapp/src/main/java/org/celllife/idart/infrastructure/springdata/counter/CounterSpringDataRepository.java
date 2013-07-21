package org.celllife.idart.domain.counter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
@RestResource(path = "counters")
public interface CounterSpringDataRepository extends CounterRepository,  CrudRepository<Counter, Long> {

    @Query("select counter from Counter counter where counter.name = :name")
    Counter findOneByName(@Param("name") String name);

}
