package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.organisation.OrganisationEvent.EventType.SAVED
import static org.celllife.idart.domain.organisation.OrganisationEvent.newOrganisationEvent

/**
 */
@Named class OrganisationServiceImpl implements OrganisationService {

    @Inject OrganisationRepository organisationRepository

    @Inject OrganisationValidator organisationValidator

    @Inject OrganisationEventPublisher organisationEventPublisher

    @Override
    Boolean exists(OrganisationId organisationId) {
        organisationRepository.exists(organisationId)
    }

    @Override
    Organisation save(Organisation organisation) {

        def existingOrganisation = organisationRepository.findOne(organisation.id)

        if (existingOrganisation == null) {
            existingOrganisation = organisation
        } else {
            existingOrganisation.merge(organisation)
        }

        organisationValidator.validate(existingOrganisation)

        organisationEventPublisher.publish(newOrganisationEvent(existingOrganisation, SAVED))

        organisationRepository.save(existingOrganisation)
    }

    @Override
    Organisation findByOrganisationId(OrganisationId organisationId) {

        def organisation = organisationRepository.findOne(organisationId)

        if (organisation == null) {
            throw new OrganisationNotFoundException("Could not find Organisation with id [${ organisationId}]")
        }

        organisation
    }

    @Override
    List<Organisation> findAll() {
        organisationRepository.findAll()
    }
}
