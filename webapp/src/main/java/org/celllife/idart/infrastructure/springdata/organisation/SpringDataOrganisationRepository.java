package org.celllife.idart.infrastructure.springdata.organisation;

import org.celllife.idart.common.PartyIdentifier;
import org.celllife.idart.domain.organisation.Organisation;
import org.celllife.idart.domain.organisation.OrganisationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataOrganisationRepository extends PagingAndSortingRepository<Organisation, PartyIdentifier>, OrganisationRepository {

}