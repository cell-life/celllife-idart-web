package org.celllife.idart.domain.eventerror

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class EventErrorServiceImpl implements EventErrorService {

    @Inject EventErrorRepository eventErrorRepository

    @Override
    EventError save(EventError eventError) {
        def saveEventError = eventError

        // if there is an existing eventError object, then merge it (and increment the retry counter)
        if (eventError.eventUuid != null) {
            def existingEventError = eventErrorRepository.findOneByEventUuid(eventError.eventUuid)
            if (existingEventError != null) {
                Integer retryCount = existingEventError.retryCount + 1
                existingEventError.merge(eventError)
                saveEventError = existingEventError
                saveEventError.retryCount = retryCount
            }
        }

        eventErrorRepository.save(saveEventError)
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