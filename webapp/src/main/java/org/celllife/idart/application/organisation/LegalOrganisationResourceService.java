package org.celllife.idart.application.organisation;

import org.celllife.idart.domain.organisation.LegalOrganisation;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationResourceService {

    LegalOrganisation save(LegalOrganisation legalOrganisation);

    LegalOrganisation findByIdentifier(String identifier);

    Iterable<LegalOrganisation> findAll();

}