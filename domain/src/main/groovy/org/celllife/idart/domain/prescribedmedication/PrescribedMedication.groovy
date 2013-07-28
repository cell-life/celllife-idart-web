package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.domain.common.*
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitutionreason.SubstitutionReason

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
@Mixin(Identifiable)
class PrescribedMedication implements Persistable<String> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/prescribedMedications"

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

    def merge(PrescribedMedication that) {

        if (that == null) {
            return
        }

        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
        this.medication = that.medication
        this.reasonForPrescribing = that.reasonForPrescribing
        that.indications?.each {indication -> this.indications << indication }
        this.valid = that.valid
        this.numberOfRepeats = that.numberOfRepeats
        this.quantity = that.quantity
        this.expectedSupplyDuration = that.expectedSupplyDuration
        this.substitution = that.substitution
        this.substitutionReason = that.substitutionReason
        this.dosageInstruction = that.dosageInstruction
    }
}
