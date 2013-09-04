package org.celllife.idart.security.encounter

import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.application.encounter.EncounterApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EncounterSecurityAdapter {

    @Inject EncounterApplicationService encounterApplicationService

    Encounter save(Principal principal, Encounter encounter) {
        encounterApplicationService.save(encounter)
    }

    Encounter findByEncounterId(Principal principal, EncounterId encounterId) {
        encounterApplicationService.findByEncounterId(encounterId)
    }

}
