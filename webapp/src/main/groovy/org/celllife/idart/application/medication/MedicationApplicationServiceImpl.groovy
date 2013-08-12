package org.celllife.idart.application.medication

import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.medication.MedicationValidationException
import org.celllife.idart.domain.medication.MedicationNotFoundException
import org.celllife.idart.common.ProductIdentifier
import org.celllife.idart.domain.medication.MedicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class MedicationApplicationServiceImpl implements MedicationApplicationService {

    @Autowired MedicationService medicationService

    Medication save(Medication medication) throws MedicationValidationException {
        medicationService.save(medication)
    }

    Medication findByProductIdentifier(ProductIdentifier productIdentifier) throws MedicationNotFoundException{
        medicationService.findByProductIdentifier(productIdentifier)
    }

}