package org.celllife.idart.domain.dispensation

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.dispensedmedication.DispensedMedication
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.prescription.Prescription

/**
 * Provision of a supply of a medication with the intention that it is subsequently consumed by a patient
 * (usually in response to a prescription).
 *
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h13
 */
@Mixin([Identifiable])
class Dispensation implements Persistable<String> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/dispensations"

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Dispensed to
     *
     * Although the patient could be inferred from the prescription, this is put here explicitly because the dispense
     * action may take place without a prescription.
     */
    Patient patient

    /**
     * Dispensed by
     */
    Practitioner dispenser

    /**
     * Contains
     */
    Set<DispensedMedication> dispensedMedications = []

    def merge(Dispensation that) {

        if (that == null) {
            return
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
        this.dispenser = that.dispenser
        that.dispensedMedications?.each { dispensedMedication -> this.dispensedMedications << dispensedMedication }
    }
}
