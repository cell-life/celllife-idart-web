package org.celllife.idart.infrastructure.springdata.eventError;

import org.celllife.idart.domain.eventerror.EventError;
import org.celllife.idart.domain.eventerror.EventErrorRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data Repository for the EventError entity
 */
public interface SpringDataEventErrorRepository extends EventErrorRepository, CrudRepository<EventError, Long> {

    EventError findOneByEventUuid(String eventUuid);
}
