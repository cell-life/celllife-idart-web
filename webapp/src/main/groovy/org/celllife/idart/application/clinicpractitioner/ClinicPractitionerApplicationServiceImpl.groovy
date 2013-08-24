package org.celllife.idart.application.clinicpractitioner

import org.celllife.idart.application.practitioner.PractitionerProvider
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.practitioner.Practitioner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 */
class ClinicPractitionerApplicationServiceImpl  {

    static final String CLINIC_PRACTITIONER_ID_SYSTEM_TEMPLATE =
        "http://www.cell-life.org/idart/clinics/%s/practitioners"

    def clinicPractitionerService

    @Autowired PractitionerProvider prehmisPractitionerProvider

    /**
     * {@inheritDoc}
     */
    void save(String clinicId, String practitionerId, Practitioner practitioner) {

        practitioner.addId(
                String.format(CLINIC_PRACTITIONER_ID_SYSTEM_TEMPLATE, clinicId),
                practitionerId
        )

        save(clinicId, practitioner)
    }

    /**
     * {@inheritDoc}
     */
    void save(String clinicId, Practitioner practitioner) {

        def clinic = clinicApplicationService.findById(clinicId)

        save(clinic, practitioner)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Practitioner> findPractitionersByClinicId(String clinicId) {

        Clinic clinic = clinicApplicationService.findById(clinicId)

        lookupFromExternalProvidersAndSave(clinic)

        clinicPractitionerService.findPractitionersByClinic(clinic)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Practitioner> findPractitionersByClinicIdAndPractitionerId(String clinicId,
                                                                                        String practitionerId) {

        clinicPractitionerService.findPractitionersByClinicIdAndPractitionerId(clinicId,
                practitionerId)
    }

    /**
     * {@inheritDoc}
     */
    Practitioner findOnePractitionerByClinicIdAndPractitionerId(String clinicId,
                                                                                String practitionerId) {

        clinicPractitionerService.findOnePractitionerByClinicIdAndPractitionerId(clinicId,
                practitionerId)
    }

    /**
     * Lookup practitioner from external providers and save
     *
     * @param clinic
     */
    void lookupFromExternalProvidersAndSave(Clinic clinic) {
        lookupFromExternalProviders(clinic).each { practitioner -> save(clinic, practitioner) }
    }

    /**
     * Lookup practitioner from external providers
     *
     * @param clinic
     * @return
     */
    Set<Practitioner> lookupFromExternalProviders(Clinic clinic) {

        Set<Practitioner> practitioners = []

        ((Facility) clinic).getIdSystems().each { idSystem ->

            String clinicIdValue = ((Facility) clinic).getIdValue(idSystem)
            switch (idSystem) {
                case "http://prehmis.capetown.gov.za":
                    practitioners << prehmisPractitionerProvider.findAll(clinicIdValue)
                    break
                default:
                    break
            }
        }

        practitioners.flatten()
    }

    /**
     * Save Practitioner and ClinicPractitioner relationship
     *
     * @param clinic
     * @param practitioner
     */
    void save(Clinic clinic, Practitioner practitioner) {

        practitioner = practitionerApplicationService.save(practitioner)

        clinicPractitionerService.save(clinic, practitioner)

    }
}
