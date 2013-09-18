package org.celllife.idart.security.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.defaultdosageinstruction.DefaultDosageInstructionApplicationService

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class DefaultDosageInstructionSecurityAdapter {

    @Inject DefaultDosageInstructionApplicationService defaultDosageInstructionApplicationService

    DefaultDosageInstructionId save(Principal principal, DefaultDosageInstructionDto defaultDosageInstructionDto) {
        defaultDosageInstructionApplicationService.save(defaultDosageInstructionDto)
    }

    DefaultDosageInstructionDto findByDefaultDosageInstructionId(Principal principal, DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionApplicationService.findByDefaultDosageInstructionId(defaultDosageInstructionId)
    }

    DefaultDosageInstructionDto findByIdentifier(Principal principal, Identifier identifier) {
        defaultDosageInstructionApplicationService.findByIdentifier(identifier)
    }

}
