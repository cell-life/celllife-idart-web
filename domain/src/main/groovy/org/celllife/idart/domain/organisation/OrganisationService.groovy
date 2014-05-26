package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId


/**
 */
public interface OrganisationService {

    Boolean exists(OrganisationId organisationId)

    Organisation save(Organisation organisation)

    Organisation findByOrganisationId(OrganisationId organisationId)

    List<Organisation> findAll()

}
