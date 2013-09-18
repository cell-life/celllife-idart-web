package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.common.Identifier


/**
 */
interface DefaultDosageInstructionApplicationService {

    Boolean exists(DefaultDosageInstructionId defaultDosageInstructionId)

    DefaultDosageInstructionId save(DefaultDosageInstructionDto defaultDosageInstructionDto)

    DefaultDosageInstructionDto findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId)

    DefaultDosageInstructionDto findByIdentifier(Identifier identifier)

    DefaultDosageInstructionId findByIdentifiers(Set<Identifier> identifiers)

}
