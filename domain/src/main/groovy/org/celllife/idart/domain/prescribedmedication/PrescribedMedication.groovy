package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.*
import org.celllife.idart.common.Duration
import org.celllife.idart.common.Period
import org.celllife.idart.common.Quantity
import org.celllife.idart.domain.dosageinstruction.DosageInstruction

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
class PrescribedMedication {

    /**
     * Namespace
     */
    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/prescribedMedications"

    /**
     * Identified by
     */
    PrescribedMedicationIdentifier identifier

    /**
     * Medication
     */
    ProductIdentifier medication

    /**
     * Reason For Prescribing
     */
    String reasonForPrescribing

    /**
     * Indications
     */
    Set<IndicationCode> indications

    /**
     * Valid Period
     */
    Period valid

    /**
     * Number Of Repeats
     */
    Integer numberOfRepeats

    /**
     * Quantity
     */
    Quantity quantity

    /**
     * Expected Supply Duration
     */
    Duration expectedSupplyDuration

    /**
     * Substitution
     */
    SubstitutionCode substitution

    /**
     * Substitution Reason
     */
    SubstitutionReasonCode substitutionReason

    /**
     * Dosage Instruction
     */
    DosageInstruction dosageInstruction

    def merge(PrescribedMedication that) {

        if (that == null) {
            return
        }

        this.medication = that.medication
        this.reasonForPrescribing = that.reasonForPrescribing
        that.indications?.each { indication -> this.indications << indication }
        this.valid = that.valid
        this.numberOfRepeats = that.numberOfRepeats
        this.quantity = that.quantity
        this.expectedSupplyDuration = that.expectedSupplyDuration
        this.substitution = that.substitution
        this.substitutionReason = that.substitutionReason
        this.dosageInstruction = that.dosageInstruction
    }
}
