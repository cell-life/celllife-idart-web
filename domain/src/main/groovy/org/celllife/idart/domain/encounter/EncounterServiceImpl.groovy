package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.encounter.EncounterEvent.EventType.SAVED
import static org.celllife.idart.domain.encounter.EncounterEvent.newEncounterEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EncounterServiceImpl implements EncounterService {

    @Autowired EncounterRepository encounterRepository

    @Autowired EncounterValidator encounterValidator

    @Autowired EncounterEventPublisher encounterEventPublisher

    @Override
    Encounter save(Encounter encounter) throws EncounterValidationException {

        encounterValidator.validate(encounter)

        encounterEventPublisher.publish(newEncounterEvent(encounter, SAVED))

        encounterRepository.save(encounter)
    }

    @Override
    Encounter findByEncounterId(EncounterId encounterId) throws EncounterNotFoundException {

        def encounter = encounterRepository.findOne(encounterId)

        if (encounter == null) {
            throw new EncounterNotFoundException("Could not find Encounter with Encounter Id [${ encounterId}]")
        }

        encounter
    }
}
