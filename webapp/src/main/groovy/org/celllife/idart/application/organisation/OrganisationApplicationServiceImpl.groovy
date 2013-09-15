package org.celllife.idart.application.organisation

import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.organisation.OrganisationNotFoundException
import org.celllife.idart.domain.organisation.OrganisationService

import static org.celllife.idart.application.organisation.dto.OrganisationDtoAssembler.toOrganisation
import static org.celllife.idart.application.organisation.dto.OrganisationDtoAssembler.toOrganisationDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.OrganisationId.organisationId
import static org.celllife.idart.domain.identifiable.IdentifiableType.ORGANISATION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class OrganisationApplicationServiceImpl implements OrganisationApplicationService {

    @Inject OrganisationService organisationService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(OrganisationId organisationId) {
        organisationService.exists(organisationId)
    }

    OrganisationId save(OrganisationDto organisationDto) {

        def organisation = toOrganisation(organisationDto)

        def identifiable = identifiableService.findByIdentifiers(ORGANISATION, organisationDto.identifiers)
        if (identifiable == null) {

            organisation = organisationService.save(organisation)

            identifiable = new Identifiable(type: ORGANISATION, identifiers: organisationDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, organisation.id.value))
            identifiableService.save(identifiable)

        } else {

            organisation.id = organisationId(identifiable.getIdentifier(IDART).value)
            organisationService.save(organisation)

        }

        organisation.id
    }

    @Override
    OrganisationDto findByOrganisationId(OrganisationId organisationId) {
        def identifier = newIdentifier(IDART, organisationId.value)
        findByIdentifier(identifier)
    }

    @Override
    OrganisationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(ORGANISATION, [identifier] as Set)

        if (identifiable == null) {
            throw new OrganisationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def organisationId = organisationId(identifiable.getIdentifier(IDART).value)

        def organisation = organisationService.findByOrganisationId(organisationId)

        def organisationDto = toOrganisationDto(organisation)
        organisationDto.identifiers = identifiable.identifiers

        organisationDto
    }
}
