package org.celllife.idart.domain.prescribedmedication

import groovy.transform.ToString

import org.celllife.idart.common.*
import org.celllife.idart.domain.dosageinstruction.DosageInstruction

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
@ToString
class PrescribedMedication implements Serializable {

    /**
     * Identified by
     */
    PrescribedMedicationId id

    /**
     * Medication
     */
    ProductId medication

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
        if (this.valid == null) {
            this.valid = that.valid
        }
        this.numberOfRepeats = that.numberOfRepeats
        this.quantity = that.quantity
        this.expectedSupplyDuration = that.expectedSupplyDuration
        this.substitution = that.substitution
        this.substitutionReason = that.substitutionReason
        this.dosageInstruction = that.dosageInstruction
    }
}
