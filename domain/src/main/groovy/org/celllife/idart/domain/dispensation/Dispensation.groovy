package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.PractitionerId

/**
 * Provision of a supply of a medication with the intention that it is subsequently consumed by a patient
 * (usually in response to a prescription).
 *
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h13
 */
class Dispensation {

    /**
     * Identified by
     */
    DispensationId id

    /**
     * Dispensed to
     *
     * Although the patient could be inferred from the prescription, this is put here explicitly because the dispense
     * action may take place without a prescription.
     */
    PractitionerId patient

    /**
     * Dispensed by
     */
    PractitionerId dispenser

    /**
     * Contains
     */
    Set<DispensedMedication> dispensedMedications = []

    def merge(Dispensation that) {

        if (that == null) {
            return
        }

        this.patient = that.patient
        this.dispenser = that.dispenser
        this.dispensedMedications?.addAll(that.dispensedMedications)
    }
}
