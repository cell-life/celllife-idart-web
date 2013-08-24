package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.organisation.OrganisationEvent.EventType.SAVED
import static org.celllife.idart.domain.organisation.OrganisationEvent.newOrganisationEvent

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

        organisationEventPublisher.publish(newOrganisationEvent(organisation, SAVED))

        organisationRepository.save(organisation)
    }

    @Override
    Organisation findByOrganisationId(OrganisationId organisationId) throws OrganisationNotFoundException {

        def organisation = organisationRepository.findOne(organisationId)

        if (organisation == null) {
            throw new OrganisationNotFoundException("Could not find Organisation with Organisation Id [${ organisationId}]")
        }

        organisation
    }
}
