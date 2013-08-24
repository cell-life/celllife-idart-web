package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface OrganisationRepository {

    Organisation save(Organisation organisation)

    Organisation findOne(OrganisationId organisationId)

}
