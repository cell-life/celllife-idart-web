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

    static final String CLINIC_PRACTITIONER_IDENTIFIER_SYSTEM_TEMPLATE =
        "http://www.cell-life.org/idart/clinics/%s/practitioners"

    def clinicPractitionerService

    @Autowired PractitionerProvider prehmisPractitionerProvider

    /**
     * {@inheritDoc}
     */
    void save(String clinicIdentifier, String practitionerIdentifier, Practitioner practitioner) {

        practitioner.addIdentifier(
                String.format(CLINIC_PRACTITIONER_IDENTIFIER_SYSTEM_TEMPLATE, clinicIdentifier),
                practitionerIdentifier
        )

        save(clinicIdentifier, practitioner)
    }

    /**
     * {@inheritDoc}
     */
    void save(String clinicIdentifier, Practitioner practitioner) {

        def clinic = clinicApplicationService.findByIdentifier(clinicIdentifier)

        save(clinic, practitioner)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Practitioner> findPractitionersByClinicIdentifier(String clinicIdentifier) {

        Clinic clinic = clinicApplicationService.findByIdentifier(clinicIdentifier)

        lookupFromExternalProvidersAndSave(clinic)

        clinicPractitionerService.findPractitionersByClinic(clinic)
    }

    /**
     * {@inheritDoc}
     */
    Iterable<Practitioner> findPractitionersByClinicIdentifierAndPractitionerIdentifier(String clinicIdentifier,
                                                                                        String practitionerIdentifier) {

        clinicPractitionerService.findPractitionersByClinicIdentifierAndPractitionerIdentifier(clinicIdentifier,
                practitionerIdentifier)
    }

    /**
     * {@inheritDoc}
     */
    Practitioner findOnePractitionerByClinicIdentifierAndPractitionerIdentifier(String clinicIdentifier,
                                                                                String practitionerIdentifier) {

        clinicPractitionerService.findOnePractitionerByClinicIdentifierAndPractitionerIdentifier(clinicIdentifier,
                practitionerIdentifier)
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

        ((Facility) clinic).getIdentifierSystems().each { identifierSystem ->

            String clinicIdentifierValue = ((Facility) clinic).getIdentifierValue(identifierSystem)
            switch (identifierSystem) {
                case "http://prehmis.capetown.gov.za":
                    practitioners << prehmisPractitionerProvider.findAll(clinicIdentifierValue)
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
