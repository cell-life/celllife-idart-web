package org.celllife.idart.application.prescription

import org.celllife.idart.application.prescribedmedication.PrescribedMedicationResourceService
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h46
 */
@Service class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService, PrescriptionResourceService {

    @Autowired PatientService patientService

    @Autowired PractitionerService practitionerService

    @Autowired PrescriptionService prescriptionService

    @Autowired PrescribedMedicationResourceService prescribedMedicationResourceService

    Prescription save(Prescription prescription) {

        prescription?.with {

            patient = patientService.findByIdentifiers(patient.identifiers)

            prescriber = practitionerService.findByIdentifiers(prescriber.identifiers)

            prescribedMedications = prescribedMedications.collect { prescribedMedication ->
                prescribedMedicationResourceService.save(prescribedMedication)
            }

        }

        prescriptionService.save(prescription)
    }

    @Override
    Prescription findByIdentifier(String identifier) {
        prescriptionService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Prescription> findAll() {
        prescriptionService.findAll()
    }
}
