package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.organisation.OrganisationEvent.EventType.SAVED
import static org.celllife.idart.domain.organisation.OrganisationEvent.newOrganisationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class OrganisationServiceImpl implements OrganisationService {

    @Inject OrganisationRepository organisationRepository

    @Inject OrganisationValidator organisationValidator

    @Inject OrganisationEventPublisher organisationEventPublisher

    @Override
    Organisation save(Organisation organisation) {

        organisationValidator.validate(organisation)

        organisationEventPublisher.publish(newOrganisationEvent(organisation, SAVED))

        organisationRepository.save(organisation)
    }

    @Override
    Organisation findByOrganisationId(OrganisationId organisationId) {

        def organisation = organisationRepository.findOne(organisationId)

        if (organisation == null) {
            throw new OrganisationNotFoundException("Could not find Organisation with Organisation Id [${ organisationId}]")
        }

        organisation
    }
}
