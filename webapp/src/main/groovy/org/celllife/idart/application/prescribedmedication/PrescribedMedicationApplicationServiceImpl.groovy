package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationService
import org.celllife.idart.domain.product.ProductService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PrescribedMedicationApplicationServiceImpl implements PrescribedMedicationApplicationService {

    @Autowired PrescribedMedicationService prescribedMedicationService

    @Autowired ProductService productService

    @Autowired UnitOfMeasureService unitOfMeasureService

    PrescribedMedication save(PrescribedMedication prescribedMedication) {
        prescribedMedicationService.save(prescribedMedication)
    }

    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationService.findByPrescribedMedicationId(prescribedMedicationId)
    }
}
