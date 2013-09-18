package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId


/**
 */
public interface DefaultDosageInstructionRepository {

    boolean exists(DefaultDosageInstructionId defaultDosageInstructionId)

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction)

    DefaultDosageInstruction findOne(DefaultDosageInstructionId defaultDosageInstructionId)

}
