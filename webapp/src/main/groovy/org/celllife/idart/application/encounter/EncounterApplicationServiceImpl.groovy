package org.celllife.idart.application.encounter

import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.EncounterValidationException
import org.celllife.idart.domain.encounter.EncounterNotFoundException
import org.celllife.idart.common.EncounterIdentifier
import org.celllife.idart.domain.encounter.EncounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EncounterApplicationServiceImpl implements EncounterApplicationService {

    @Autowired EncounterService encounterService

    Encounter save(Encounter encounter) throws EncounterValidationException {
        encounterService.save(encounter)
    }

    Encounter findByEncounterIdentifier(EncounterIdentifier encounterIdentifier) throws EncounterNotFoundException{
        encounterService.findByEncounterIdentifier(encounterIdentifier)
    }

}