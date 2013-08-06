package org.celllife.idart.domain.organisation

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationService {

    LegalOrganisation save(LegalOrganisation legalOrganisation)

    Iterable<LegalOrganisation> findAll()

    LegalOrganisation findByIdentifier(String identifier)

    LegalOrganisation findByIdentifiers(Iterable<Identifier> identifiers)

}