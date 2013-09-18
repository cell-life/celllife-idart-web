package org.celllife.idart.security.encounter

import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.common.EncounterId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.encounter.EncounterApplicationService

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class EncounterSecurityAdapter {

    @Inject EncounterApplicationService encounterApplicationService

    EncounterId save(Principal principal, EncounterDto encounterDto) {
        encounterApplicationService.save(encounterDto)
    }

    EncounterDto findByEncounterId(Principal principal, EncounterId encounterId) {
        encounterApplicationService.findByEncounterId(encounterId)
    }

    EncounterDto findByIdentifier(Principal principal, Identifier identifier) {
        encounterApplicationService.findByIdentifier(identifier)
    }

}
