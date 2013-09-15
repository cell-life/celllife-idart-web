package org.celllife.idart.application.practitioner

import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.organisation.Organisation

import javax.annotation.Generated

/**
 */
interface PractitionerApplicationService {

    PractitionerId save(PractitionerDto practitionerDto)

    PractitionerDto findByPractitionerId(PractitionerId practitionerId)

    PractitionerDto findByIdentifier(Identifier identifier)

    Set<PractitionerDto> findByFacility(FacilityId facility)

    Set<PractitionerDto> findBySystem(SystemId system)

    Set<PractitionerDto> findByPerson(PersonId personId)

}
