package org.celllife.idart.application.dispensation

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.application.dispensation.dto.DispensationDtoAssembler
import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.dispensation.DispensationNotFoundException
import org.celllife.idart.domain.dispensation.DispensationService
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.DispensationId.dispensationId
import static org.celllife.idart.common.IdentifiableType.DISPENSATION
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.relationship.systemfacility.SystemFacility.Relationship.DEPLOYED_AT

/**
 */
@Named class DispensationApplicationServiceImpl implements DispensationApplicationService {

    @Inject DispensationService dispensationService

    @Inject DispensationDtoAssembler dispensationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Inject SystemFacilityService systemFacilityService

    @Override
    Boolean exists(DispensationId dispensationId) {
        dispensationService.exists(dispensationId)
    }

    @Override
    DispensationId save(SystemId system, DispensationDto dispensationDto) {

        def facility = systemFacilityService.findFacility(system, DEPLOYED_AT)

        dispensationDto.facility << newIdentifier(facility.value)

        save(dispensationDto)
    }

    @Override
    DispensationId save(DispensationDto dispensationDto) {

        def identifiable = identifiableService.resolveIdentifiable(DISPENSATION, dispensationDto.identifiers)
        dispensationDto.identifiers = identifiable.identifiers

        def dispensationId = dispensationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def dispensation = dispensationDtoAssembler.toDispensation(dispensationDto)
        dispensation.id = dispensationId

        dispensationService.save(dispensation)

        dispensation.id
    }

    @Override
    DispensationDto findByDispensationId(DispensationId dispensationId) {
        def identifier = newIdentifier(dispensationId.value)
        findByIdentifier(identifier)
    }

    @Override
    DispensationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(DISPENSATION, [identifier] as Set)

        if (identifiable == null) {
            throw new DispensationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def dispensationId = dispensationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def dispensation = dispensationService.findByDispensationId(dispensationId)

        def dispensationDto = dispensationDtoAssembler.toDispensationDto(dispensation)
        dispensationDto.identifiers = identifiable.identifiers

        dispensationDto
    }

    @Override
    DispensationId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(DISPENSATION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        dispensationId(idartIdentifierValue)
    }
}
