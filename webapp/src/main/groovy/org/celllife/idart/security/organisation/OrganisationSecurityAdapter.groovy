package org.celllife.idart.security.organisation

import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.organisation.OrganisationApplicationService

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class OrganisationSecurityAdapter {

    @Inject OrganisationApplicationService organisationApplicationService

    OrganisationId save(Principal principal, OrganisationDto organisationDto) {
        organisationApplicationService.save(organisationDto)
    }

    OrganisationDto findByOrganisationId(Principal principal, OrganisationId organisationId) {
        organisationApplicationService.findByOrganisationId(organisationId)
    }

    OrganisationDto findByIdentifier(Principal principal, Identifier identifier) {
        organisationApplicationService.findByIdentifier(identifier)
    }

    List<OrganisationDto> findAll() {
        organisationApplicationService.findAll()
    }

}
