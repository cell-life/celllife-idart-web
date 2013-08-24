package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidationException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionNotFoundException
import org.celllife.idart.common.DefaultDosageInstructionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DefaultDosageInstructionApplicationService {

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) throws DefaultDosageInstructionValidationException

    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) throws DefaultDosageInstructionNotFoundException

}