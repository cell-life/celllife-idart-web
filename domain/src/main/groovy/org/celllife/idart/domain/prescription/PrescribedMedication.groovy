package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Duration
import org.celllife.idart.domain.common.Period
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.common.Quantity
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.product.Good
import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitutionreason.SubstitutionReason

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
class PrescribedMedication implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Medication
     */
    Medication medication

    /**
     * Reason For Prescribing
     */
    String reasonForPrescribing

    /**
     * Indications
     */
    Set<Indication> indications

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
    Substitution substitution

    /**
     * Substitution Reason
     */
    SubstitutionReason substitutionReason

    /**
     * Dosage Instruction
     */
    DosageInstruction dosageInstruction

}
