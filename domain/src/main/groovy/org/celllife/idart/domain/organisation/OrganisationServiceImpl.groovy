package org.celllife.idart.domain.organisation

import org.celllife.idart.common.PartyIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class OrganisationServiceImpl implements OrganisationService {

    @Autowired OrganisationRepository organisationRepository

    @Autowired OrganisationValidator organisationValidator

    @Autowired OrganisationEventPublisher organisationEventPublisher

    @Override
    Organisation save(Organisation organisation) throws OrganisationValidationException {

        organisationValidator.validate(organisation)

        organisationEventPublisher.organisationSaved(organisation)

        organisationRepository.save(organisation)
    }

    @Override
    Organisation findByPartyIdentifier(PartyIdentifier partyIdentifier) throws OrganisationNotFoundException {

        def organisation = organisationRepository.findOne(partyIdentifier)

        if (organisation == null) {
            throw new OrganisationNotFoundException("Could not find Organisation with Party Identifier [${ partyIdentifier}]")
        }

        organisation
    }
}