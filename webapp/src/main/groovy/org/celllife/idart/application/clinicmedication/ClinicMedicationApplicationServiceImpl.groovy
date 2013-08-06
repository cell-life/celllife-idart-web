package org.celllife.idart.application.clinicmedication

import org.celllife.idart.application.clinic.ClinicResourceService
import org.celllife.idart.application.medication.MedicationResourceService
import org.celllife.idart.domain.medication.Medication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service    

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicMedicationApplicationServiceImpl  {

    @Autowired ClinicResourceService clinicResourceService

    @Autowired MedicationResourceService medicationResourceService

    def clinicMedicationService

    void save(String clinicIdentifier, String medicationIdentifier, Medication medication) {

        medication.addIdentifier(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/medications",
                        clinicIdentifier
                ),
                medicationIdentifier
        )

        save(clinicIdentifier, medication)
    }

    void save(String clinicIdentifier, Medication medication) {

        def clinic = clinicResourceService.findByIdentifier(clinicIdentifier)

        medication = medicationResourceService.save(medication)

        clinicMedicationService.save(clinic, medication)
    }

    Iterable<Medication> findMedicationsByClinicIdentifier(String clinicIdentifier) {
         clinicMedicationService.findMedicationsByClinicIdentifier(clinicIdentifier)
    }

    Iterable<Medication> findMedicationsByClinicIdentifierAndMedicationIdentifier(String clinicIdentifier, String medicationIdentifier) {

    }

    Medication findOneMedicationByClinicIdentifierAndMedicationIdentifier(String clinicIdentifier, String medicationIdentifier) {

    }
}
