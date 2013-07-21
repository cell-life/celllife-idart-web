package org.celllife.idart.application.prescription

import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionService
import org.celllife.idart.domain.product.GoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h46
 */
@Service class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService {

    @Autowired PatientService patientService

    @Autowired PractitionerService practitionerService

    @Autowired GoodService goodService

    @Autowired PrescriptionService prescriptionService

    def save(Prescription prescription) {

        prescription.patient = patientService.save(prescription.patient)

        prescription.prescriber = practitionerService.save(prescription.prescriber)

        prescription.prescribedMedications.each { prescribedMedication ->
            prescribedMedication.medication = goodService.save(prescribedMedication.medication)
        }

        prescriptionService.save(prescription)
    }
}
