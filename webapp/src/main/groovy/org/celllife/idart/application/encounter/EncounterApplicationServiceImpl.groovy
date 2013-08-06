package org.celllife.idart.application.encounter

import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.EncounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EncounterApplicationServiceImpl implements EncounterApplicationService, EncounterResourceService {

    @Autowired EncounterService encounterService

    Encounter save(Encounter encounter) {
        encounterService.save(encounter)
    }

    Encounter findByIdentifier(String identifier) {
        encounterService.findByIdentifier(identifier)
    }

    Iterable<Encounter> findAll() {
        encounterService.findAll()
    }

}