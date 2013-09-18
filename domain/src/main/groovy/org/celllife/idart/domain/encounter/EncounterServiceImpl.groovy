package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.encounter.EncounterEvent.EventType.SAVED
import static org.celllife.idart.domain.encounter.EncounterEvent.newEncounterEvent

/**
 */
@Named class EncounterServiceImpl implements EncounterService {

    @Inject EncounterRepository encounterRepository

    @Inject EncounterValidator encounterValidator

    @Inject EncounterEventPublisher encounterEventPublisher

    @Override
    Boolean exists(EncounterId encounterId) {
        encounterRepository.exists(encounterId)
    }

    @Override
    Encounter save(Encounter encounter) {

        def existingEncounter = encounterRepository.findOne(encounter.id)

        if (existingEncounter == null) {
            existingEncounter = encounter
        } else {
            existingEncounter.merge(encounter)
        }

        encounterValidator.validate(existingEncounter)

        encounterEventPublisher.publish(newEncounterEvent(existingEncounter, SAVED))

        encounterRepository.save(existingEncounter)
    }

    @Override
    Encounter findByEncounterId(EncounterId encounterId) {

        def encounter = encounterRepository.findOne(encounterId)

        if (encounter == null) {
            throw new EncounterNotFoundException("Could not find Encounter with id [${ encounterId}]")
        }

        encounter
    }
}
