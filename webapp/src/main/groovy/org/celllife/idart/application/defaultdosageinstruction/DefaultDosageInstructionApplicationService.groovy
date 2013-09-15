package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DefaultDosageInstructionApplicationService {

    Boolean exists(DefaultDosageInstructionId defaultDosageInstructionId)

    DefaultDosageInstructionId save(DefaultDosageInstructionDto defaultDosageInstructionDto)

    DefaultDosageInstructionDto findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId)

    DefaultDosageInstructionDto findByIdentifier(Identifier identifier)

}
