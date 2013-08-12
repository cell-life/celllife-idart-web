package org.celllife.idart.domain.legalorganisation

import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationRepository {

    LegalOrganisation save(LegalOrganisation legalOrganisation)

    LegalOrganisation findOne(PartyIdentifier partyIdentifier)

}
