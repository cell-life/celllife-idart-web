package org.celllife.idart.application.encounter

import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.encounter.EncounterNotFoundException
import org.celllife.idart.domain.encounter.EncounterService

import static org.celllife.idart.application.encounter.dto.EncounterDtoAssembler.toEncounter
import static org.celllife.idart.application.encounter.dto.EncounterDtoAssembler.toEncounterDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.EncounterId.encounterId
import static org.celllife.idart.domain.identifiable.IdentifiableType.ENCOUNTER
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EncounterApplicationServiceImpl implements EncounterApplicationService {

    @Inject EncounterService encounterService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(EncounterId encounterId) {
        encounterService.exists(encounterId)
    }

    EncounterId save(EncounterDto encounterDto) {

        def encounter = toEncounter(encounterDto)

        def identifiable = identifiableService.findByIdentifiers(ENCOUNTER, encounterDto.identifiers)
        if (identifiable == null) {

            encounter = encounterService.save(encounter)

            identifiable = new Identifiable(type: ENCOUNTER, identifiers: encounterDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, encounter.id.value))
            identifiableService.save(identifiable)

        } else {

            encounter.id = encounterId(identifiable.getIdentifier(IDART).value)
            encounterService.save(encounter)

        }

        encounter.id
    }

    @Override
    EncounterDto findByEncounterId(EncounterId encounterId) {
        def identifier = newIdentifier(IDART, encounterId.value)
        findByIdentifier(identifier)
    }

    @Override
    EncounterDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(ENCOUNTER, [identifier] as Set)

        if (identifiable == null) {
            throw new EncounterNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def encounterId = encounterId(identifiable.getIdentifier(IDART).value)

        def encounter = encounterService.findByEncounterId(encounterId)

        def encounterDto = toEncounterDto(encounter)
        encounterDto.identifiers = identifiable.identifiers

        encounterDto
    }
}
