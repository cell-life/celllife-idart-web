package org.celllife.idart.application.organisation;

import org.celllife.idart.domain.organisation.LegalOrganisation;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationResourceService {

    LegalOrganisation save(LegalOrganisation legalOrganisation);

    LegalOrganisation findByIdentifier(String identifier);

    Iterable<LegalOrganisation> findAll();

}