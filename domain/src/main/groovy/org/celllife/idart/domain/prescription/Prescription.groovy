package org.celllife.idart.domain.prescription

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import org.celllife.idart.common.*

/**
 * An order for both supply of the medication and the instructions for administration of the medicine to a patient.
 */
@ToString
@EqualsAndHashCode
class Prescription implements Serializable {

    /**
     * Identified by
     */
    PrescriptionId id

    /**
     * Prescribed by
     */
    PractitionerId prescriber

    /**
     * Prescribed to
     */
    PatientId patient

    /**
     * Written on
     */
    Date dateWritten

    /**
     * During
     */
    EncounterId encounter

    /**
     * Contains
     */
    Set<PrescribedMedicationId> prescribedMedications = []

    def merge(Prescription that) {

        if (that == null) {
            return
        }

        this.prescriber = that.prescriber
        this.patient = that.patient
        this.dateWritten = that.dateWritten
        that.prescribedMedications.each { prescribedMedication -> this.prescribedMedications << prescribedMedication }
    }
}
