package org.celllife.idart.application.part

import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.IdentifiableType.PRACTITIONER
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PractitionerId.practitionerId
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Systems.PREHMIS

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.part.dto.AtcCodeDto
import org.celllife.idart.common.*
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.relationship.systemfacility.SystemFacility
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

/**
 * 
 */
@Named class AtcCodeApplicationServiceImpl implements AtcCodeApplicationService {


    @Inject DrugProvider prehmisDrugProvider
	@Inject SystemFacilityService systemFacilityService
	@Inject IdentifiableService identifiableService


    @Override
    Set<AtcCodeDto> findByFacility(FacilityId facilityId) {

        def atcCodes = lookupFromExternalProviders(facilityId)

        atcCodes
    }

    Set<AtcCodeDto> findBySystem(SystemId system) {

        def facility = systemFacilityService.findFacility(system, SystemFacility.Relationship.DEPLOYED_AT)

        def atcCodes = findByFacility(facility)

        atcCodes
    }

    Set<AtcCodeDto> findByPerson(PersonId personId) {

    }

    Set<AtcCodeDto> lookupFromExternalProviders(FacilityId facility) {

        def facilityIdentifiable = identifiableService.resolveIdentifiable(FACILITY, newIdentifiers(facility.value))

        def atcCodes = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            switch (facilityIdentifier.system) {
                case PREHMIS.id:
                    return prehmisDrugProvider.findAll(facilityIdentifier.value)
                default:
                    return [] as Set<AtcCodeDto>
            }
        }

        atcCodes.flatten()
    }
}
