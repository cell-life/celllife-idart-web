package org.celllife.idart.application.lifeevent.dto

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class LifeEventDtoAssembler {

    LifeEvent toLifeEvent(LifeEventDto lifeEventDto) {

        def lifeEvent = new LifeEvent()
        lifeEvent.with {

        }

        lifeEvent
    }

    LifeEventDto toLifeEventDto(LifeEvent lifeEvent) {

        def lifeEventDto = new LifeEventDto()
        lifeEventDto.with {

        }

        lifeEventDto
    }
}
