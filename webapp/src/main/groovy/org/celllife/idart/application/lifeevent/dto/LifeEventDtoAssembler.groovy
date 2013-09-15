package org.celllife.idart.application.lifeevent.dto

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventDtoAssembler {

    static LifeEvent toLifeEvent(LifeEventDto lifeEventDto) {

        def lifeEvent = new LifeEvent()
        lifeEvent.with {

        }

        lifeEvent
    }

    static LifeEventDto toLifeEventDto(LifeEvent lifeEvent) {

        def lifeEventDto = new LifeEventDto()
        lifeEventDto.with {

        }

        lifeEventDto
    }
}
