package org.celllife.idart.application.legalorganisation

import org.celllife.idart.domain.legalorganisation.LegalOrganisation
import org.celllife.idart.domain.legalorganisation.LegalOrganisationValidationException
import org.celllife.idart.domain.legalorganisation.LegalOrganisationNotFoundException
import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface LegalOrganisationApplicationService {

    LegalOrganisation save(LegalOrganisation legalOrganisation) throws LegalOrganisationValidationException

    LegalOrganisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws LegalOrganisationNotFoundException

}