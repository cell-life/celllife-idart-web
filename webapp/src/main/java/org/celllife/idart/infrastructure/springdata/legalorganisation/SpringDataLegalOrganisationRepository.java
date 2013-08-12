package org.celllife.idart.infrastructure.springdata.legalorganisation;

import org.celllife.idart.common.PartyIdentifier;
import org.celllife.idart.domain.legalorganisation.LegalOrganisation;
import org.celllife.idart.domain.legalorganisation.LegalOrganisationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataLegalOrganisationRepository extends LegalOrganisationRepository,
        PagingAndSortingRepository<LegalOrganisation, PartyIdentifier> {

}