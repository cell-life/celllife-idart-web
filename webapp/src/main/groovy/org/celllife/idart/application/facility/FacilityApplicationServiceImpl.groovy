package org.celllife.idart.application.facility

import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.facility.dto.FacilityDtoAssembler
import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.domain.facility.FacilityService

import static org.celllife.idart.common.FacilityId.facilityId
import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class FacilityApplicationServiceImpl implements FacilityApplicationService {

    @Inject FacilityService facilityService   

    @Inject FacilityDtoAssembler facilityDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(FacilityId facilityId) {
        facilityService.exists(facilityId)
    }

    @Override
    FacilityId save(FacilityDto facilityDto) {

        def identifiable = identifiableService.resolveIdentifiable(FACILITY, facilityDto.identifiers)
        facilityDto.identifiers = identifiable.identifiers

        def facilityId = facilityId(identifiable.getIdentifierValue(IDART_WEB.id))

        def facility = facilityDtoAssembler.toFacility(facilityDto)
        facility.id = facilityId

        facilityService.save(facility)

        facility.id
    }

    @Override
    FacilityDto findByFacilityId(FacilityId facilityId) {
        def identifier = newIdentifier(facilityId.value)
        findByIdentifier(identifier)
    }

    @Override
    FacilityDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(FACILITY, [identifier] as Set)

        if (identifiable == null) {
            throw new FacilityNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def facilityId = facilityId(identifiable.getIdentifierValue(IDART_WEB.id))

        def facility = facilityService.findByFacilityId(facilityId)

        def facilityDto = facilityDtoAssembler.toFacilityDto(facility)
        facilityDto.identifiers = identifiable.identifiers

        facilityDto
    }

    @Override
    FacilityId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(FACILITY, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        facilityId(idartIdentifierValue)
    }
}
