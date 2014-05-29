package org.celllife.idart.application.organisation

import static org.celllife.idart.common.IdentifiableType.ORGANISATION
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.OrganisationId.organisationId
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.application.organisation.dto.OrganisationDtoAssembler
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationNotFoundException
import org.celllife.idart.domain.organisation.OrganisationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class OrganisationApplicationServiceImpl implements OrganisationApplicationService {
    
    static final Logger LOGGER = LoggerFactory.getLogger(OrganisationApplicationServiceImpl)

    @Inject OrganisationService organisationService   

    @Inject OrganisationDtoAssembler organisationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(OrganisationId organisationId) {
        organisationService.exists(organisationId)
    }

    @Override
    @Transactional
    OrganisationId save(OrganisationDto organisationDto) {

        def identifiable = identifiableService.resolveIdentifiable(ORGANISATION, organisationDto.identifiers)
        organisationDto.identifiers = identifiable.identifiers

        def organisationId = organisationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def organisation = organisationDtoAssembler.toOrganisation(organisationDto)
        organisation.id = organisationId

        organisationService.save(organisation)

        organisation.id
    }

    @Override
    @Transactional(readOnly = true)
    List<OrganisationDto> findAll() {
        def all = organisationService.findAll()
        List<OrganisationDto> allDto = new ArrayList<OrganisationDto>()
        for (Organisation o : all) {
            OrganisationDto dto = organisationDtoAssembler.toOrganisationDto(o)
            Identifier identifier = newIdentifier(o.getId().value) // have to set the identifier separately (?)
            dto.setIdentifiers([identifier] as Set)
            allDto.add(dto)
        }
        return allDto
    }

    @Override
    @Transactional(readOnly = true)
    OrganisationDto findByOrganisationId(OrganisationId organisationId) {
        def identifier = newIdentifier(organisationId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    OrganisationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(ORGANISATION, [identifier] as Set)
        if (identifiable == null) {
            throw new OrganisationNotFoundException("Could not find Organisation with id [${identifier}]")
        }

        def organisationId = organisationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def organisation = organisationService.findByOrganisationId(organisationId)

        def organisationDto = organisationDtoAssembler.toOrganisationDto(organisation)
        organisationDto.identifiers = identifiable.identifiers

        organisationDto
    }

    @Override
    @Transactional(readOnly = true)
    OrganisationId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(ORGANISATION, identifiers)
        if (identifiable == null) {
            throw new OrganisationNotFoundException("Could not find Organisation with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        organisationId(idartIdentifierValue)
    }
}