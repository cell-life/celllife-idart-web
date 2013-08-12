package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.common.DispensedMedicationIdentifier
import org.celllife.idart.common.PrescribedMedicationIdentifier
import org.celllife.idart.common.ProductIdentifier
import org.celllife.idart.common.Period
import org.celllife.idart.common.Quantity
import org.celllife.idart.domain.dosageinstruction.DosageInstruction

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
class DispensedMedication {

    /**
     * Namespace
     */
    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/dispensedMedications"

    /**
     * Identified by
     */
    DispensedMedicationIdentifier identifier

    /**
     * Medication
     */
    ProductIdentifier medication

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
    PrescribedMedicationIdentifier authorizingPrescribedMedication


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
