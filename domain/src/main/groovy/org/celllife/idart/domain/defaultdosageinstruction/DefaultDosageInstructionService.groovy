package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DefaultDosageInstructionService {

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) throws DefaultDosageInstructionValidationException

    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) throws DefaultDosageInstructionNotFoundException

}
