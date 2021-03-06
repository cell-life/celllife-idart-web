package org.celllife.idart.application.organisation

import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.OrganisationId


/**
 */
interface OrganisationApplicationService {

    Boolean exists(OrganisationId organisationId)

    OrganisationId save(OrganisationDto organisationDto)

    OrganisationDto findByOrganisationId(OrganisationId organisationId)

    OrganisationDto findByIdentifier(Identifier identifier)

    OrganisationId findByIdentifiers(Set<Identifier> identifiers)

    List<OrganisationDto> findAll()

}
