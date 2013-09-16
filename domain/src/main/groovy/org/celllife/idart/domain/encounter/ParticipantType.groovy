package org.celllife.idart.domain.encounter

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-16
 * Time: 18h31
 */
enum ParticipantType {

    ADMITTER("The practitioner responsible for admitting a patient to a hospital or other inpatient health facility."),
    DISCHARGER("The practitioner responsible for discharging the patient from a hospital or other inpatient health facility."),
    RESPONSIBLE("The practitioner responsible for overseeing a patient's care during a patient encounter."),
    ATTENDING("The practitioner responsible for overseeing a patient's care during a patient encounter."),
    CONSULTING("An advisor participating in the service by performing evaluations and making recommendations."),
    REFERRER("The practitioner that referred the patient to another practitioner.")

    final String description

    ParticipantType(String description) {
        this.description = description
    }
}