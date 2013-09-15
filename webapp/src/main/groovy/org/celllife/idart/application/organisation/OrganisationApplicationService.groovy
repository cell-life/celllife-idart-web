package org.celllife.idart.application.organisation

import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface OrganisationApplicationService {

    Boolean exists(OrganisationId organisationId)

    OrganisationId save(OrganisationDto organisationDto)

    OrganisationDto findByOrganisationId(OrganisationId organisationId)

    OrganisationDto findByIdentifier(Identifier identifier)

}
