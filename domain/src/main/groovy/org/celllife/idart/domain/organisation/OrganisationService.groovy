package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface OrganisationService {

    Organisation save(Organisation organisation) throws OrganisationValidationException

    Organisation findByOrganisationId(OrganisationId organisationId) throws OrganisationNotFoundException

}
