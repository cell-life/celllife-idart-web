package org.celllife.idart.application.encounter

import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.application.encounter.dto.EncounterDtoAssembler
import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.encounter.EncounterNotFoundException
import org.celllife.idart.domain.encounter.EncounterService

import static org.celllife.idart.common.EncounterId.encounterId
import static org.celllife.idart.common.IdentifiableType.ENCOUNTER
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class EncounterApplicationServiceImpl implements EncounterApplicationService {

    @Inject EncounterService encounterService   

    @Inject EncounterDtoAssembler encounterDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(EncounterId encounterId) {
        encounterService.exists(encounterId)
    }

    @Override
    @Transactional
    EncounterId save(EncounterDto encounterDto) {

        def identifiable = identifiableService.resolveIdentifiable(ENCOUNTER, encounterDto.identifiers)
        encounterDto.identifiers = identifiable.identifiers

        def encounterId = encounterId(identifiable.getIdentifierValue(IDART_WEB.id))

        def encounter = encounterDtoAssembler.toEncounter(encounterDto)
        encounter.id = encounterId

        encounterService.save(encounter)

        encounter.id
    }

    @Override
    @Transactional(readOnly = true)
    EncounterDto findByEncounterId(EncounterId encounterId) {
        def identifier = newIdentifier(encounterId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    EncounterDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(ENCOUNTER, [identifier] as Set)

        if (identifiable == null) {
            throw new EncounterNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def encounterId = encounterId(identifiable.getIdentifierValue(IDART_WEB.id))

        def encounter = encounterService.findByEncounterId(encounterId)

        def encounterDto = encounterDtoAssembler.toEncounterDto(encounter)
        encounterDto.identifiers = identifiable.identifiers

        encounterDto
    }

    @Override
    @Transactional(readOnly = true)
    EncounterId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(ENCOUNTER, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        encounterId(idartIdentifierValue)
    }
}