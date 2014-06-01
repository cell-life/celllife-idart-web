package org.celllife.idart.domain.eventerror

import java.util.List;

/**
 */
public interface EventErrorService {

    EventError save(EventError eventError)
    
    void delete(Long pk)
    
    EventError findByEventErrorId(Long pk)

    EventError findByEventUuid(String uuid)
    
    List<EventError> findAll()
}
