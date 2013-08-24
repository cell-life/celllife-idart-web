package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidationException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionNotFoundException
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DefaultDosageInstructionApplicationServiceImpl implements DefaultDosageInstructionApplicationService {

    @Autowired DefaultDosageInstructionService defaultDosageInstructionService

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) throws DefaultDosageInstructionValidationException {
        defaultDosageInstructionService.save(defaultDosageInstruction)
    }

    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) throws DefaultDosageInstructionNotFoundException{
        defaultDosageInstructionService.findByDefaultDosageInstructionId(defaultDosageInstructionId)
    }

}
