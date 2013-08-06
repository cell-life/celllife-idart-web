package org.celllife.idart.application.clinicpatient

import org.celllife.idart.application.clinic.ClinicResourceService
import org.celllife.idart.application.patient.PatientProvider
import org.celllife.idart.application.patient.PatientResourceService
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicNotFoundException
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.patient.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 */
@Service class ClinicPatientApplicationServiceImpl {

    @Autowired ClinicResourceService clinicResourceService

    @Autowired PatientResourceService patientResourceService

    def clinicPatientService

    @Autowired PatientProvider prehmisPatientProvider

    /**
     * {@inheritDoc}
     */
    void save(String clinicIdentifier, String patientIdentifier, Patient patient) {

        patient.addIdentifier(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/patients",
                        clinicIdentifier
                ),
                patientIdentifier
        )

        save(clinicIdentifier, patient)
    }

    /**
     * {@inheritDoc}
     */
    void save(String clinicIdentifier, Patient patient) {

        def clinic = clinicResourceService.findByIdentifier(clinicIdentifier)

        save(clinic, patient)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Patient> findPatientsByClinicIdentifier(String clinicIdentifier) {

        clinicPatientService.findPatientsByClinicIdentifier(clinicIdentifier)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Patient> findPatientsByClinicIdentifierAndPatientIdentifier(String clinicIdentifier,
                                                                         String patientIdentifier) {

        Clinic clinic = clinicResourceService.findByIdentifier(clinicIdentifier)

        if (clinic == null) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + clinicIdentifier)
        }

        lookupFromExternalProvidersAndSave(patientIdentifier, clinic)

        clinicPatientService.findPatientsByClinicIdentifierAndPatientIdentifier(clinicIdentifier, patientIdentifier)
    }

    /**
     * {@inheritDoc}
     */
    Patient findOnePatientByClinicIdentifierAndPatientIdentifier(String clinicIdentifier,
                                                                 String patientIdentifier) {

        clinicPatientService.findOnePatientByClinicIdentifierAndPatientIdentifier(clinicIdentifier, patientIdentifier)
    }

    /**
     * Lookup patients from external providers and save
     *
     * @param clinic
     */
    void lookupFromExternalProvidersAndSave(String patientIdentifier, Clinic clinic) {

        lookupFromExternalProviders(patientIdentifier, clinic).each { practitioner -> save(clinic, practitioner) }
    }

    /**
     *
     * @param patientIdentifier
     * @param clinic
     * @return
     */
    Set<Patient> lookupFromExternalProviders(String patientIdentifier, Clinic clinic) {

        Set<Patient> patients = []

        for (String identifierSystem : ((Facility) clinic).identifierSystems) {
            String clinicIdentifier = ((Facility) clinic).getIdentifierValue(identifierSystem)
            switch (identifierSystem) {
                case "http://prehmis.capetown.gov.za":
                    patients << prehmisPatientProvider.findByIdentifier(clinicIdentifier, patientIdentifier)
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

        patient = patientResourceService.save(patient)

        clinicPatientService.save(clinic, patient)
    }
}
