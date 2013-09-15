package org.celllife.idart.security.organisation

import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.identifiable.Identifier
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

    OrganisationId save(Principal principal, organisationDto) {
        organisationApplicationService.save(organisationDto)
    }

    OrganisationDto findByOrganisationId(Principal principal, OrganisationId organisationId) {
        organisationApplicationService.findByOrganisationId(organisationId)
    }

    OrganisationDto findByIdentifier(Principal principal, Identifier identifier) {
        organisationApplicationService.findByIdentifier(identifier)
    }

}
