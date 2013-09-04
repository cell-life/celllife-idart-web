package org.celllife.idart.security.organisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.application.organisation.OrganisationApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class OrganisationSecurityAdapter {

    @Inject OrganisationApplicationService organisationApplicationService

    Organisation save(Principal principal, Organisation organisation) {
        organisationApplicationService.save(organisation)
    }

    Organisation findByOrganisationId(Principal principal, OrganisationId organisationId) {
        organisationApplicationService.findByOrganisationId(organisationId)
    }

}
