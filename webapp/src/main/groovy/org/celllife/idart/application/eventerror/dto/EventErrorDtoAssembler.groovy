package org.celllife.idart.application.eventerror.dto

import javax.inject.Named

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.eventerror.EventError

/**
 * Converts a DTO object to the domain Entity object and the other way around
 */
@Named class EventErrorDtoAssembler {

    /**
     * Note that this creates an EventError without the eventObject blob
     */
    EventError toEventError(EventErrorDto eventErrorDto) {

        def eventError = new EventError()
        eventError.with {
            pk = eventErrorDto.pk
            datetime = eventErrorDto.datetime
            retryCount = eventErrorDto.retryCount
            eventType = eventErrorDto.eventType
            eventUuid = eventErrorDto.eventUuid
            errorMessage = eventErrorDto.errorMessage
        }

        eventError
    }

    EventErrorDto toEventErrorDto(EventError eventError) {

        def eventErrorDto = new EventErrorDto()
        eventErrorDto.with {
            pk = eventError.pk
            datetime = eventError.datetime
            retryCount = eventError.retryCount
            eventType = eventError.eventType
            eventUuid = eventError.eventUuid
            errorMessage = eventError.errorMessage
        }

        eventErrorDto
    }
}
