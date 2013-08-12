package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DefaultDosageInstructionService {

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) throws DefaultDosageInstructionValidationException

    DefaultDosageInstruction findByDefaultDosageInstructionIdentifier(DefaultDosageInstructionIdentifier defaultDosageInstructionIdentifier) throws DefaultDosageInstructionNotFoundException

}