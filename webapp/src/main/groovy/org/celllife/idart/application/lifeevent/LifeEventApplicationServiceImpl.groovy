package org.celllife.idart.application.lifeevent

import org.celllife.idart.application.lifeevent.dto.LifeEventDto
import org.celllife.idart.application.lifeevent.dto.LifeEventDtoAssembler
import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.lifeevent.LifeEventNotFoundException
import org.celllife.idart.domain.lifeevent.LifeEventService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.LifeEventCode.lifeEventCode
import static org.celllife.idart.common.IdentifiableType.LIFE_EVENT
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class LifeEventApplicationServiceImpl implements LifeEventApplicationService {

    @Inject LifeEventService lifeEventService   

    @Inject LifeEventDtoAssembler lifeEventDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(LifeEventCode lifeEventCode) {
        lifeEventService.exists(lifeEventCode)
    }

    @Override
    LifeEventCode save(LifeEventDto lifeEventDto) {

        def identifiable = identifiableService.resolveIdentifiable(LIFE_EVENT, lifeEventDto.identifiers)

        def lifeEventCode = lifeEventCode(identifiable.getIdentifierValue(IDART))

        def lifeEvent = lifeEventDtoAssembler.toLifeEvent(lifeEventDto)
        lifeEvent.id = lifeEventCode

        lifeEventService.save(lifeEvent)

        lifeEvent.id
    }

    @Override
    LifeEventDto findByLifeEventCode(LifeEventCode lifeEventCode) {
        def identifier = newIdentifier(IDART, lifeEventCode.value)
        findByIdentifier(identifier)
    }

    @Override
    LifeEventDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(LIFE_EVENT, [identifier] as Set)

        if (identifiable == null) {
            throw new LifeEventNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def lifeEventCode = lifeEventCode(identifiable.getIdentifierValue(IDART))

        def lifeEvent = lifeEventService.findByLifeEventCode(lifeEventCode)

        def lifeEventDto = lifeEventDtoAssembler.toLifeEventDto(lifeEvent)
        lifeEventDto.identifiers = identifiable.identifiers

        lifeEventDto
    }

    @Override
    LifeEventCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(LIFE_EVENT, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        lifeEventCode(idartIdentifierValue)
    }
}
