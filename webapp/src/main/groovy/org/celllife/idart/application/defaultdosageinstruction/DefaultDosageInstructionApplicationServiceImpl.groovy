package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService
import org.celllife.idart.domain.part.FinishedGoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 22h10
 */
@Service class DefaultDosageInstructionApplicationServiceImpl implements DefaultDosageInstructionApplicationService {

    @Autowired DefaultDosageInstructionService defaultDosageInstructionService

    @Autowired FinishedGoodService finishedGoodService

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {

        defaultDosageInstruction.medication =
            finishedGoodService.findByIdentifiers(defaultDosageInstruction.medication.identifiers)

        defaultDosageInstructionService.save(defaultDosageInstruction)
    }
}
