package org.celllife.idart.application.organisation

import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationValidationException
import org.celllife.idart.domain.organisation.OrganisationNotFoundException
import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface OrganisationApplicationService {

    Organisation save(Organisation organisation) throws OrganisationValidationException

    Organisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws OrganisationNotFoundException

}