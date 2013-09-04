package org.celllife.idart.security.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
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

    DefaultDosageInstruction save(Principal principal, DefaultDosageInstruction defaultDosageInstruction) {
        defaultDosageInstructionApplicationService.save(defaultDosageInstruction)
    }

    DefaultDosageInstruction findByDefaultDosageInstructionId(Principal principal, DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionApplicationService.findByDefaultDosageInstructionId(defaultDosageInstructionId)
    }

}
