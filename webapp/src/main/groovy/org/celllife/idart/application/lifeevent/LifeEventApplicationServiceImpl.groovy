package org.celllife.idart.application.lifeevent

import org.celllife.idart.application.lifeevent.dto.LifeEventDto
import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.lifeevent.LifeEventNotFoundException
import org.celllife.idart.domain.lifeevent.LifeEventService

import static org.celllife.idart.application.lifeevent.dto.LifeEventDtoAssembler.toLifeEvent
import static org.celllife.idart.application.lifeevent.dto.LifeEventDtoAssembler.toLifeEventDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.LifeEventCode.lifeEventCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.LIFE_EVENT
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class LifeEventApplicationServiceImpl implements LifeEventApplicationService {

    @Inject LifeEventService lifeEventService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(LifeEventCode lifeEventCode) {
        lifeEventService.exists(lifeEventCode)
    }

    LifeEventCode save(LifeEventDto lifeEventDto) {

        def lifeEvent = toLifeEvent(lifeEventDto)

        def identifiable = identifiableService.findByIdentifiers(LIFE_EVENT, lifeEventDto.identifiers)
        if (identifiable == null) {

            lifeEvent = lifeEventService.save(lifeEvent)

            identifiable = new Identifiable(type: LIFE_EVENT, identifiers: lifeEventDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, lifeEvent.id.value))
            identifiableService.save(identifiable)

        } else {

            lifeEvent.id = lifeEventCode(identifiable.getIdentifier(IDART).value)
            lifeEventService.save(lifeEvent)

        }

        lifeEvent.id
    }

    @Override
    LifeEventDto findByLifeEventCode(LifeEventCode lifeEventCode) {
        def identifier = newIdentifier(IDART, lifeEventCode.value)
        findByIdentifier(identifier)
    }

    @Override
    LifeEventDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(LIFE_EVENT, [identifier] as Set)

        if (identifiable == null) {
            throw new LifeEventNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def lifeEventCode = lifeEventCode(identifiable.getIdentifier(IDART).value)

        def lifeEvent = lifeEventService.findByLifeEventCode(lifeEventCode)

        def lifeEventDto = toLifeEventDto(lifeEvent)
        lifeEventDto.identifiers = identifiable.identifiers

        lifeEventDto
    }
}
