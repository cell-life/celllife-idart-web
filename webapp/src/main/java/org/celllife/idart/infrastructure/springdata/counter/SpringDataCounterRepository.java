package org.celllife.idart.infrastructure.springdata.counter;

import org.celllife.idart.domain.counter.Counter;
import org.celllife.idart.domain.counter.CounterRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.persistence.LockModeType;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
@RestResource(path = "counters")
public interface SpringDataCounterRepository extends CounterRepository, CrudRepository<Counter, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select counter from Counter counter where counter.name = :name")
    Counter findOneByName(@Param("name") String name);

}
