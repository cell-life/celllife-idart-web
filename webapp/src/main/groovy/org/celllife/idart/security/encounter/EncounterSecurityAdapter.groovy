package org.celllife.idart.security.encounter

import org.celllife.idart.application.encounter.dto.EncounterDto
import org.celllife.idart.common.EncounterId
import org.celllife.idart.domain.identifiable.Identifier
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

    EncounterId save(Principal principal, encounterDto) {
        encounterApplicationService.save(encounterDto)
    }

    EncounterDto findByEncounterId(Principal principal, EncounterId encounterId) {
        encounterApplicationService.findByEncounterId(encounterId)
    }

    EncounterDto findByIdentifier(Principal principal, Identifier identifier) {
        encounterApplicationService.findByIdentifier(identifier)
    }

}
