package org.celllife.idart.infrastructure.springdata.organisation;

import org.celllife.idart.common.OrganisationId;
import org.celllife.idart.domain.organisation.Organisation;
import org.celllife.idart.domain.organisation.OrganisationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataOrganisationRepository extends OrganisationRepository,
        PagingAndSortingRepository<Organisation, OrganisationId> {

}
