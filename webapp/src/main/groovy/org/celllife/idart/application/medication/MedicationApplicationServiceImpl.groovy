package org.celllife.idart.application.medication

import org.celllife.idart.application.drug.DrugResourceService
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.medication.MedicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 */
@Service class MedicationApplicationServiceImpl implements MedicationApplicationService, MedicationResourceService {

    @Autowired DrugResourceService drugResourceService

    @Autowired MedicationService medicationService

    Medication save(Medication medication) {

        medication?.with {
            drug = drugResourceService.save(drug)
        }

        medicationService.save(medication)
    }

    Medication findByIdentifier(String identifier) {
        medicationService.findByIdentifier(identifier)
    }

    Iterable<Medication> findAll() {
        medicationService.findAll()
    }

}