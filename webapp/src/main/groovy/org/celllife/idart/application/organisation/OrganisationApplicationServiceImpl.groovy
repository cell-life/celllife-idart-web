package org.celllife.idart.application.organisation

import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationValidationException
import org.celllife.idart.domain.organisation.OrganisationNotFoundException
import org.celllife.idart.common.PartyIdentifier
import org.celllife.idart.domain.organisation.OrganisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class OrganisationApplicationServiceImpl implements OrganisationApplicationService {

    @Autowired OrganisationService organisationService

    Organisation save(Organisation organisation) throws OrganisationValidationException {
        organisationService.save(organisation)
    }

    Organisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws OrganisationNotFoundException{
        organisationService.findByPartyIdentifier(partyIdentifier)
    }

}