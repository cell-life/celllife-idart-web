package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService
import org.celllife.idart.domain.part.FinishedGoodService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 22h10
 */
@Service class DefaultDosageInstructionApplicationServiceImpl implements DefaultDosageInstructionApplicationService,
        DefaultDosageInstructionResourceService{

    @Autowired DefaultDosageInstructionService defaultDosageInstructionService

    @Autowired FinishedGoodService finishedGoodService

    @Autowired UnitOfMeasureService unitOfMeasureService

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {

        defaultDosageInstruction.with {

            medication = finishedGoodService.findByIdentifiers(medication.identifiers)

            dosageInstruction?.with {
                doseQuantity?.with {
                    unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                }

                timing?.with {
                    repeat?.with {
                        duration?.with {
                            unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                        }
                    }
                }
            }
        }
        
        defaultDosageInstructionService.save(defaultDosageInstruction)
    }

    @Override
    DefaultDosageInstruction findByIdentifier(String medicationIdentifier) {
        return defaultDosageInstructionService.findByIdentifier(medicationIdentifier)
    }

    @Override
    Iterable<DefaultDosageInstruction> findAll() {
        defaultDosageInstructionService.findAll()
    }
}
