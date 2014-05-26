package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId


/**
 */
public interface OrganisationRepository {

    boolean exists(OrganisationId organisationId)

    Organisation save(Organisation organisation)

    Organisation findOne(OrganisationId organisationId)
    
    List<Organisation> findAll()

}
