package org.celllife.idart.application.eventerror

import org.celllife.idart.application.eventerror.dto.EventErrorDto


/**
 */
interface EventErrorApplicationService {
    
    EventErrorDto findByEventErrorId(Long pk)

    void delete(Long pk)
    
    List<EventErrorDto> findAll()

    void reprocess(List<Long> eventErrorPks)

}
