package org.celllife.idart.application.organisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.organisation.Organisation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface OrganisationApplicationService {

    Organisation save(Organisation organisation)

    Organisation findByOrganisationId(OrganisationId organisationId)

}
