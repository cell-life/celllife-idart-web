package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationIdentifier
import org.celllife.idart.common.DispensedMedicationIdentifier
import org.celllife.idart.common.PractitionerIdentifier

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
     * Namespace
     */
    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/dispensations"

    /**
     * Identified by
     */
    DispensationIdentifier identifier

    /**
     * Dispensed to
     *
     * Although the patient could be inferred from the prescription, this is put here explicitly because the dispense
     * action may take place without a prescription.
     */
    PractitionerIdentifier patient

    /**
     * Dispensed by
     */
    PractitionerIdentifier dispenser

    /**
     * Contains
     */
    Set<DispensedMedicationIdentifier> dispensedMedications = []

    def merge(Dispensation that) {

        if (that == null) {
            return
        }

        this.patient = that.patient
        this.dispenser = that.dispenser
        this.dispensedMedications?.addAll(that.dispensedMedications)
    }
}
