package org.celllife.idart.security.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.application.defaultdosageinstruction.DefaultDosageInstructionApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DefaultDosageInstructionSecurityAdapter {

    @Inject DefaultDosageInstructionApplicationService defaultDosageInstructionApplicationService

    DefaultDosageInstructionId save(Principal principal, defaultDosageInstructionDto) {
        defaultDosageInstructionApplicationService.save(defaultDosageInstructionDto)
    }

    DefaultDosageInstructionDto findByDefaultDosageInstructionId(Principal principal, DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionApplicationService.findByDefaultDosageInstructionId(defaultDosageInstructionId)
    }

    DefaultDosageInstructionDto findByIdentifier(Principal principal, Identifier identifier) {
        defaultDosageInstructionApplicationService.findByIdentifier(identifier)
    }

}
