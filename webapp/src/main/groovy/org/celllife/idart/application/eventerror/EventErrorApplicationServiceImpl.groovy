package org.celllife.idart.application.eventerror

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.dispensation.DispensationProvider
import org.celllife.idart.application.eventerror.dto.EventErrorDto
import org.celllife.idart.application.eventerror.dto.EventErrorDtoAssembler
import org.celllife.idart.application.prescription.PrescriptionProvider
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.eventerror.EventError
import org.celllife.idart.domain.eventerror.EventErrorNotFoundException
import org.celllife.idart.domain.eventerror.EventErrorService
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional

/**
 * Application service for EventError. Uses the EventErrorService, but uses DTOs in order
 * to interact with the clients
 */
@Named class EventErrorApplicationServiceImpl implements EventErrorApplicationService {
    
    static final Logger LOGGER = LoggerFactory.getLogger(EventErrorApplicationServiceImpl.class)

    @Inject EventErrorService eventErrorService   

    @Inject EventErrorDtoAssembler eventErrorDtoAssembler

    @Inject PrescriptionProvider prescriptionProvider
    
    @Inject DispensationProvider dispensationProvider
    
    @Override
    @Transactional(readOnly = true)
    EventErrorDto findByEventErrorId(Long pk) {
        EventError eventError = eventErrorService.findByEventErrorId(pk)
        EventErrorDto eventErrorDto = eventErrorDtoAssembler.toEventErrorDto(eventError)
        return eventErrorDto
    }
    
    @Override
    @Transactional
    void delete(Long pk) {
        eventErrorService.delete(pk)
    }
    
    @Override
    @Transactional(readOnly = true)
    List<EventErrorDto> findAll() {
        List<EventError> eventErrors = eventErrorService.findAll()
        List<EventErrorDto> eventErrorDtos = new ArrayList<EventErrorDto>()
        for (EventError ee : eventErrors) {
            eventErrorDtos.add(eventErrorDtoAssembler.toEventErrorDto(ee))
        }
        return eventErrorDtos
    }

    @Override
    @Transactional
    void reprocess(List<Long> eventErrorPks) {
        for (Long pk : eventErrorPks) {
            EventError eventError = null
            try {
                eventError = eventErrorService.findByEventErrorId(pk)
            } catch (EventErrorNotFoundException e) {
                LOGGER.error("Could not find EventError with pk ${pk}, so it cannot be reprocessed")
            }
            if (eventError != null) {
                EventError.EventType eventType = eventError.getEventType()
                Object eventObject = eventError.getDeserializedEventObject();
                LOGGER.debug("Reprocessing "+eventType+" event with "+eventObject)
                if (eventObject != null) {
                    switch (eventType) {
                        case EventError.EventType.PRESCRIPTION_EVENT:
                            reprocessPrescriptionEvent(eventError, eventObject)
                            break
                        case EventError.EventType.DISPENSATION_EVENT:
                            reprocessDispensationEvent(eventError, eventObject)
                            break
                    }
                }
            }
        }
    }
    
    private void reprocessPrescriptionEvent(EventError eventError, Object eventObject) {
        try {
            PrescriptionEvent prescriptionEvent = (PrescriptionEvent)eventObject
            prescriptionProvider.processEvent(prescriptionEvent)
            eventErrorService.delete(eventError.pk)
        } catch (Throwable t) {
            String errorMessage = "Error while re-processing ${eventError.eventType} event. " + t.getMessage()
            LOGGER.error(errorMessage, t)
            incrementRetryCount(eventError, errorMessage)
        }
    }

    private void reprocessDispensationEvent(EventError eventError, Object eventObject) {
        try {
            DispensationEvent dispensationEvent = (DispensationEvent)eventObject
            dispensationProvider.processEvent(dispensationEvent)
            eventErrorService.delete(eventError.pk)
        } catch (Throwable t) {
            String errorMessage = "Error while re-processing ${eventError.eventType} event. " + t.getMessage()
            LOGGER.error(errorMessage, t)
            incrementRetryCount(eventError, errorMessage)
        }
    }
    
    private void incrementRetryCount(EventError eventError, String errorMessage) {
        EventError eventError2 = eventErrorService.findByEventErrorId(eventError.pk)
        if (eventError2.retryCount == eventError.retryCount) {
            eventError2.errorMessage = errorMessage
            eventError2.retryCount = eventError.retryCount + 1
            eventErrorService.save(eventError2)
        }
    }
}