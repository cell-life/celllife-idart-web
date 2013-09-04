package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DefaultDosageInstructionApplicationService {

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction)

    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId)

}
