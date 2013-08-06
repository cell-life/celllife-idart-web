package org.celllife.idart.domain.organisation;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationRepository {

    LegalOrganisation save(LegalOrganisation legalOrganisation)

    public <S extends LegalOrganisation> Iterable<S> save(Iterable<S> legalOrganisations)

    LegalOrganisation findOne(Long pk)

    Iterable<LegalOrganisation> findAll()

    LegalOrganisation findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<LegalOrganisation> findByIdentifier(String identifierValue)
}
