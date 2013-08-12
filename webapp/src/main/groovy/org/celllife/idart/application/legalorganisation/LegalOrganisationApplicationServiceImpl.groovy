package org.celllife.idart.application.legalorganisation

import org.celllife.idart.domain.legalorganisation.LegalOrganisation
import org.celllife.idart.domain.legalorganisation.LegalOrganisationValidationException
import org.celllife.idart.domain.legalorganisation.LegalOrganisationNotFoundException
import org.celllife.idart.common.PartyIdentifier
import org.celllife.idart.domain.legalorganisation.LegalOrganisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LegalOrganisationApplicationServiceImpl implements LegalOrganisationApplicationService {

    @Autowired LegalOrganisationService legalOrganisationService

    LegalOrganisation save(LegalOrganisation legalOrganisation) throws LegalOrganisationValidationException {
        legalOrganisationService.save(legalOrganisation)
    }

    LegalOrganisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws LegalOrganisationNotFoundException{
        legalOrganisationService.findByPartyIdentifier(partyIdentifier)
    }

}