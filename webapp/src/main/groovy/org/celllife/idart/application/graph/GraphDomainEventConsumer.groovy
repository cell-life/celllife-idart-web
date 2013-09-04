package org.celllife.idart.application.graph
/**
 * User: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h39
 */
public interface GraphDomainEventConsumer {

    void handleAdministrationMethodEvent(String message)

    void handleDefaultDosageInstructionEvent(String message)

    void handleDispensationEvent(String message)

    void handleEncounterEvent(String message)

    void handleEntrySiteEvent(String message)

    void handleFacilityEvent(String message)

    void handleFormEvent(String message)

    void handleIndicationEvent(String message)

    void handleLegalOrganisationEvent(String message)

    void handleLifeEventEvent(String message)

    void handleMedicationEvent(String message)

    void handleOrganisationEvent(String message)

    void handlePartEvent(String message)

    void handlePatientEvent(String message)

    void handlePersonEvent(String message)

    void handlePractitionerEvent(String message)

    void handlePrescribedMedicationEvent(String message)

    void handlePrescriptionEvent(String message)

    void handleRouteOfAdministrationEvent(String message)

    void handleSubstitutionEvent(String message)

    void handleSubstitutionReasonEvent(String message)

    void handleSystemEvent(String message)

    void handleSystemFacilityEvent(String message)

    void handleUnitOfMeasureEvent(String message)

    void handleUnitOfMeasureTypeEvent(String message)

    void handleUserEvent(String message)

    void handleUserSystemEvent(String message)
}
