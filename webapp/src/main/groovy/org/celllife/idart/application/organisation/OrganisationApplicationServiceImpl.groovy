package org.celllife.idart.application.organisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class OrganisationApplicationServiceImpl implements OrganisationApplicationService {

    @Inject OrganisationService organisationService

    Organisation save(Organisation organisation) {
        organisationService.save(organisation)
    }

    Organisation findByOrganisationId(OrganisationId organisationId) {
        organisationService.findByOrganisationId(organisationId)
    }

}
