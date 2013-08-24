package org.celllife.idart.infrastructure.springdata.organisation;

import org.celllife.idart.common.OrganisationId;
import org.celllife.idart.domain.organisation.Organisation;
import org.celllife.idart.domain.organisation.OrganisationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataOrganisationRepository extends OrganisationRepository,
        PagingAndSortingRepository<Organisation, OrganisationId> {

}
