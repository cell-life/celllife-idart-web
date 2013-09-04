package org.celllife.idart.application.clinicmedication

import org.celllife.idart.domain.product.Medication
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicMedicationApplicationServiceImpl  {

    def clinicMedicationService

    void save(String clinicId, String medicationId, Medication medication) {

        medication.addId(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/medications",
                        clinicId
                ),
                medicationId
        )

        save(clinicId, medication)
    }

    void save(String clinicId, Medication medication) {

        def clinic = clinicApplicationService.findById(clinicId)

        medication = medicationApplicationService.save(medication)

        clinicMedicationService.save(clinic, medication)
    }

    Iterable<Medication> findMedicationsByClinicId(String clinicId) {
         clinicMedicationService.findMedicationsByClinicId(clinicId)
    }

    Iterable<Medication> findMedicationsByClinicIdAndMedicationId(String clinicId, String medicationId) {

    }

    Medication findOneMedicationByClinicIdAndMedicationId(String clinicId, String medicationId) {

    }
}
