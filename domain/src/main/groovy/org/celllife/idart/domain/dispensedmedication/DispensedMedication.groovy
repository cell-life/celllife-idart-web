package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Period
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.common.Quantity
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
@Mixin(Identifiable)
class DispensedMedication implements Persistable<String> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/dispensedMedications"

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Medication
     */
    Medication medication

    /**
     * Quantity
     */
    Quantity quantity

    /**
     * When prepared
     */
    Period prepared

    /**
     * When handed over
     */
    Period handedOver

    /**
     * Dosage Instruction
     */
    DosageInstruction dosageInstruction

    /**
     * Authorized by
     */
    PrescribedMedication authorizingPrescribedMedication


    def merge(DispensedMedication that) {

        if (that == null) {
            return
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
        this.medication = that.medication
        this.quantity = that.quantity
        this.prepared = that.prepared
        this.handedOver = that.handedOver
        this.authorizingPrescribedMedication = that.authorizingPrescribedMedication
    }

}
