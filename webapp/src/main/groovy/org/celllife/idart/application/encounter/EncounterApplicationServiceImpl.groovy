package org.celllife.idart.application.encounter

import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.EncounterService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EncounterApplicationServiceImpl implements EncounterApplicationService {

    @Inject EncounterService encounterService

    Encounter save(Encounter encounter) {
        encounterService.save(encounter)
    }

    Encounter findByEncounterId(EncounterId encounterId) {
        encounterService.findByEncounterId(encounterId)
    }

}
