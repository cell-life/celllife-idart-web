package org.celllife.idart.application.clinicpatient

import org.celllife.idart.application.patient.PatientProvider
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.patient.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 */
class ClinicPatientApplicationServiceImpl {

    def clinicPatientService

    @Autowired PatientProvider prehmisPatientProvider

    /**
     * {@inheritDoc}
     */
    void save(String clinicId, String patientId, Patient patient) {

        patient.addId(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/patients",
                        clinicId
                ),
                patientId
        )

        save(clinicId, patient)
    }

    /**
     * {@inheritDoc}
     */
    void save(String clinicId, Patient patient) {

        def clinic = clinicApplicationService.findById(clinicId)

        save(clinic, patient)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Patient> findPatientsByClinicId(String clinicId) {

        clinicPatientService.findPatientsByClinicId(clinicId)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Patient> findPatientsByClinicIdAndPatientId(String clinicId,
                                                                         String patientId) {

        Clinic clinic = clinicApplicationService.findById(clinicId)

        if (clinic == null) {
//            throw new ClinicNotFoundException("Clinic not found for id value: " + clinicId)
        }

        lookupFromExternalProvidersAndSave(patientId, clinic)

        clinicPatientService.findPatientsByClinicIdAndPatientId(clinicId, patientId)
    }

    /**
     * {@inheritDoc}
     */
    Patient findOnePatientByClinicIdAndPatientId(String clinicId,
                                                                 String patientId) {

        clinicPatientService.findOnePatientByClinicIdAndPatientId(clinicId, patientId)
    }

    /**
     * Lookup patients from external providers and save
     *
     * @param clinic
     */
    void lookupFromExternalProvidersAndSave(String patientId, Clinic clinic) {

        lookupFromExternalProviders(patientId, clinic).each { practitioner -> save(clinic, practitioner) }
    }

    /**
     *
     * @param patientId
     * @param clinic
     * @return
     */
    Set<Patient> lookupFromExternalProviders(String patientId, Clinic clinic) {

        Set<Patient> patients = []

        for (String idSystem : ((Facility) clinic).idSystems) {
            String clinicId = ((Facility) clinic).getIdValue(idSystem)
            switch (idSystem) {
                case "http://prehmis.capetown.gov.za":
                    patients << prehmisPatientProvider.findById(clinicId, patientId)
                    break
                default:
                    break
            }
        }

        patients.flatten()
    }

    /**
     *
     * @param clinic
     * @param patient
     */
    void save(Clinic clinic, Patient patient) {

        patient = patientApplicationService.save(patient)

        clinicPatientService.save(clinic, patient)
    }
}
