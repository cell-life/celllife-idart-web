package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DefaultDosageInstructionApplicationServiceImpl implements DefaultDosageInstructionApplicationService {

    @Inject DefaultDosageInstructionService defaultDosageInstructionService

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {
        defaultDosageInstructionService.save(defaultDosageInstruction)
    }

    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionService.findByDefaultDosageInstructionId(defaultDosageInstructionId)
    }

}
