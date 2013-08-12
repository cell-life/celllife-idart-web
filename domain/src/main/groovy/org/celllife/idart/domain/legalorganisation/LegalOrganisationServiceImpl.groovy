package org.celllife.idart.domain.legalorganisation

import org.celllife.idart.common.PartyIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.legalorganisation.LegalOrganisationEvent.EventType.SAVED
import static org.celllife.idart.domain.legalorganisation.LegalOrganisationEvent.newLegalOrganisationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LegalOrganisationServiceImpl implements LegalOrganisationService {

    @Autowired LegalOrganisationRepository legalOrganisationRepository

    @Autowired LegalOrganisationValidator legalOrganisationValidator

    @Autowired LegalOrganisationEventPublisher legalOrganisationEventPublisher

    @Override
    LegalOrganisation save(LegalOrganisation legalOrganisation) throws LegalOrganisationValidationException {

        legalOrganisationValidator.validate(legalOrganisation)

        legalOrganisationEventPublisher.publish(newLegalOrganisationEvent(legalOrganisation, SAVED))

        legalOrganisationRepository.save(legalOrganisation)
    }

    @Override
    LegalOrganisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws LegalOrganisationNotFoundException {

        def legalOrganisation = legalOrganisationRepository.findOne(partyIdentifier)

        if (legalOrganisation == null) {
            throw new LegalOrganisationNotFoundException("Could not find LegalOrganisation with Party Identifier [${ partyIdentifier}]")
        }

        legalOrganisation
    }
}