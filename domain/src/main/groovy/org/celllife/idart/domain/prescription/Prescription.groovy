package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication

/**
 * An order for both supply of the medication and the instructions for administration of the medicine to a patient.
 *
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h49
 */
@Mixin([Identifiable])
class Prescription implements Persistable<String> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/prescriptions"

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Prescribed by
     */
    Practitioner prescriber

    /**
     * Prescribed to
     */
    Patient patient

    /**
     * Written on
     */
    Date dateWritten

    /**
     * During
     */
    Encounter encounter

    /**
     * Contains
     */
    Set<PrescribedMedication> prescribedMedications = []

    def merge(Prescription that) {

        if (that == null) {
            return
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
        this.prescriber = that.prescriber
        this.patient = that.patient
        this.dateWritten = that.dateWritten
        that.prescribedMedications.each { prescribedMedication -> this.prescribedMedications << prescribedMedication }
    }
}
