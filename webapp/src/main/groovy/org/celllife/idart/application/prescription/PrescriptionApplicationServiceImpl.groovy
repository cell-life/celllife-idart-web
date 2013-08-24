package org.celllife.idart.application.prescription

import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.prescription.PrescriptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService {

    @Autowired PrescriptionService prescriptionService

    Prescription save(Prescription prescription) throws PrescriptionValidationException {
        prescriptionService.save(prescription)
    }

    Prescription findByPrescriptionId(PrescriptionId prescriptionId) throws PrescriptionNotFoundException{
        prescriptionService.findByPrescriptionId(prescriptionId)
    }

}
