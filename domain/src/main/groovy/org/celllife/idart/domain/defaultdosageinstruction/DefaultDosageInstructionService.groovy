package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DefaultDosageInstructionService {

    Boolean exists(DefaultDosageInstructionId defaultDosageInstructionId)

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction)

    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId)

}
