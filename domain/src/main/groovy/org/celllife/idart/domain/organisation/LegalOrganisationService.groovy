package org.celllife.idart.domain.organisation;

import org.celllife.idart.domain.common.Identifier;

import java.util.Set;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationService {

    LegalOrganisation save(LegalOrganisation legalOrganisation);

    Iterable<LegalOrganisation> findAll();

    LegalOrganisation findByIdentifier(String identifier);

    LegalOrganisation findByIdentifiers(Set<Identifier> identifiers);


}