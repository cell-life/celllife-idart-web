package org.celllife.idart.application.facility

import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.domain.facility.FacilityService

import static org.celllife.idart.application.facility.dto.FacilityDtoAssembler.toFacility
import static org.celllife.idart.application.facility.dto.FacilityDtoAssembler.toFacilityDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.FacilityId.facilityId
import static org.celllife.idart.domain.identifiable.IdentifiableType.FACILITY
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class FacilityApplicationServiceImpl implements FacilityApplicationService {

    @Inject FacilityService facilityService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(FacilityId facilityId) {
        facilityService.exists(facilityId)
    }

    FacilityId save(FacilityDto facilityDto) {

        def facility = toFacility(facilityDto)

        def identifiable = identifiableService.findByIdentifiers(FACILITY, facilityDto.identifiers)
        if (identifiable == null) {

            facility = facilityService.save(facility)

            identifiable = new Identifiable(type: FACILITY, identifiers: facilityDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, facility.id.value))
            identifiableService.save(identifiable)

        } else {

            facility.id = facilityId(identifiable.getIdentifier(IDART).value)
            facilityService.save(facility)

        }

        facility.id
    }

    @Override
    FacilityDto findByFacilityId(FacilityId facilityId) {
        def identifier = newIdentifier(IDART, facilityId.value)
        findByIdentifier(identifier)
    }

    @Override
    FacilityDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(FACILITY, [identifier] as Set)

        if (identifiable == null) {
            throw new FacilityNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def facilityId = facilityId(identifiable.getIdentifier(IDART).value)

        def facility = facilityService.findByFacilityId(facilityId)

        def facilityDto = toFacilityDto(facility)
        facilityDto.identifiers = identifiable.identifiers

        facilityDto
    }
}
