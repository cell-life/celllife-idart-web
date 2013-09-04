package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.encounter.EncounterEvent.EventType.SAVED
import static org.celllife.idart.domain.encounter.EncounterEvent.newEncounterEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EncounterServiceImpl implements EncounterService {

    @Inject EncounterRepository encounterRepository

    @Inject EncounterValidator encounterValidator

    @Inject EncounterEventPublisher encounterEventPublisher

    @Override
    Encounter save(Encounter encounter) {

        encounterValidator.validate(encounter)

        encounterEventPublisher.publish(newEncounterEvent(encounter, SAVED))

        encounterRepository.save(encounter)
    }

    @Override
    Encounter findByEncounterId(EncounterId encounterId) {

        def encounter = encounterRepository.findOne(encounterId)

        if (encounter == null) {
            throw new EncounterNotFoundException("Could not find Encounter with Encounter Id [${ encounterId}]")
        }

        encounter
    }
}
