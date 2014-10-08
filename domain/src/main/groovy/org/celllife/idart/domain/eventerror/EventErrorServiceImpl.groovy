package org.celllife.idart.domain.eventerror

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class EventErrorServiceImpl implements EventErrorService {

    @Inject EventErrorRepository eventErrorRepository

    @Override
    EventError save(EventError eventError) {
        eventErrorRepository.save(eventError)
    }

    @Override
    EventError findByEventErrorId(Long pk) {

        def eventError = eventErrorRepository.findOne(pk)

        if (eventError == null) {
            throw new EventErrorNotFoundException("Could not find EventError with id [${eventErrorId}]")
        }

        eventError
    }

    @Override
    EventError findByEventUuid(String uuid) {
        
        def eventError = eventErrorRepository.findOneByEventUuid(uuid);
        if (eventError == null) {
            throw new EventErrorNotFoundException("Could not find EventError with eventUuid [${uuid}]")
        }

        eventError
    }

    @Override
    void delete(Long pk) {
        eventErrorRepository.delete(pk)
    }

    @Override
    List<EventError> findAll() {
        return eventErrorRepository.findAll()
    }
}