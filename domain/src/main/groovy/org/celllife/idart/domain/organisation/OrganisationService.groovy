package org.celllife.idart.domain.organisation

import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface OrganisationService {

    Organisation save(Organisation organisation) throws OrganisationValidationException

    Organisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws OrganisationNotFoundException

}