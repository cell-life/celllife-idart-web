package org.celllife.idart.domain.legalorganisation

import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LegalOrganisationService {

    LegalOrganisation save(LegalOrganisation legalOrganisation) throws LegalOrganisationValidationException

    LegalOrganisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws LegalOrganisationNotFoundException

}