package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.Period
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.common.ProductId
import org.celllife.idart.common.Quantity
import org.celllife.idart.domain.dosageinstruction.DosageInstruction

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
class DispensedMedication {

    /**
     * Medication
     */
    ProductId medication

    /**
     * Quantity
     */
    Quantity quantity

    /**
     * Prepared during
     */
    Period prepared

    /**
     * Handed over during
     */
    Period handedOver

    /**
     * Dosage Instruction
     */
    DosageInstruction dosageInstruction

    /**
     * Authorized by
     */
    PrescribedMedicationId authorizingPrescribedMedication


    def merge(DispensedMedication that) {

        if (that == null) {
            return
        }

        this.medication = that.medication
        this.quantity = that.quantity
        this.prepared = that.prepared
        this.handedOver = that.handedOver
        this.authorizingPrescribedMedication = that.authorizingPrescribedMedication
    }

}
