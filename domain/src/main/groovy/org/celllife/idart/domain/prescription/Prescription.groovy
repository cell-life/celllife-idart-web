package org.celllife.idart.domain.prescription

import org.celllife.idart.common.*

/**
 * An order for both supply of the medication and the instructions for administration of the medicine to a patient.
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h49
 */
class Prescription {

    /**
     * Namespace
     */
    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/prescriptions"

    /**
     * Identified by
     */
    PrescriptionIdentifier identifier

    /**
     * Prescribed by
     */
    PractitionerIdentifier prescriber

    /**
     * Prescribed to
     */
    PatientIdentifier patient

    /**
     * Written on
     */
    Date dateWritten

    /**
     * During
     */
    EncounterIdentifier encounter

    /**
     * Contains
     */
    Set<PrescribedMedicationIdentifier> prescribedMedications = []

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
