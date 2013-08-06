package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.domain.medication.MedicationService
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 */
@Service
class PrescribedMedicationApplicationServiceImpl implements PrescribedMedicationApplicationService, PrescribedMedicationResourceService {

    @Autowired PrescribedMedicationService prescribedMedicationService

    @Autowired MedicationService medicationService

    @Autowired UnitOfMeasureService unitOfMeasureService

    PrescribedMedication save(PrescribedMedication prescribedMedication) {

        prescribedMedication?.with {

            medication = medicationService.findByIdentifiers(medication.identifiers)

            dosageInstruction?.with {

                doseQuantity?.with {
                    unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                }

                expectedSupplyDuration?.with {
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

        prescribedMedicationService.save(prescribedMedication)
    }

    PrescribedMedication findByIdentifier(String identifier) {
        prescribedMedicationService.findByIdentifier(identifier)
    }

    Iterable<PrescribedMedication> findAll() {
        prescribedMedicationService.findAll()
    }

}