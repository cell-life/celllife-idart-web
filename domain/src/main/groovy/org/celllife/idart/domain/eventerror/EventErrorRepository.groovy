package org.celllife.idart.domain.eventerror

/**
 */
public interface EventErrorRepository {

    EventError save(EventError eventError)

    void delete(EventError eventError)

    EventError findOne(Long pk)
    
    EventError findOneByEventUuid(String eventUuid)

    List<EventError> findAll()
}
