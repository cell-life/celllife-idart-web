package org.celllife.idart.domain.encounter

import org.celllife.idart.common.EncounterIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

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

        encounterEventPublisher.encounterSaved(encounter)

        encounterRepository.save(encounter)
    }

    @Override
    Encounter findByEncounterIdentifier(EncounterIdentifier encounterIdentifier) throws EncounterNotFoundException {

        def encounter = encounterRepository.findOne(encounterIdentifier)

        if (encounter == null) {
            throw new EncounterNotFoundException("Could not find Encounter with Encounter Identifier [${ encounterIdentifier}]")
        }

        encounter
    }
}