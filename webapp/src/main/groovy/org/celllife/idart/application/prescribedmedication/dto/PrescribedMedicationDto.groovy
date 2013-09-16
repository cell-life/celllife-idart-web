package org.celllife.idart.application.prescribedmedication.dto

import org.celllife.idart.common.*
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h34
 */
class PrescribedMedicationDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Medication
     */
    Set<Identifier> medication

    /**
     * Reason For Prescribing
     */
    String reasonForPrescribing

    /**
     * Indications
     */
    Set<IndicationCode> indications = []

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

}
