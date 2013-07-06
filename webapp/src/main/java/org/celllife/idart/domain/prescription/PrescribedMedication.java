package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.domain.indication.Indication;
import org.celllife.idart.domain.substitution.Substitution;
import org.celllife.idart.domain.substitutionreason.SubstitutionReason;
import org.celllife.idart.domain.common.Period;
import org.celllife.idart.domain.product.Good;
import org.celllife.idart.udm.common.Duration;
import org.celllife.idart.udm.common.Quantity;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h52
 */
public final class PrescribedMedication implements Persistable, Serializable {

    /**
     * Medication
     */
    private Good medication;

    /**
     * Reason For Prescribing
     */
    private String reasonForPrescribing;

    /**
     * Indications
     */
    private Set<Indication> indications;

    /**
     * Valid Period
     */
    private Period valid;

    /**
     * Number Of Repeats
     */
    private Integer numberOfRepeats;

    /**
     * Quantity
     */
    private Quantity quantity;

    /**
     * Expected Supply Duration
     */
    private Duration expectedSupplyDuration;

    /**
     * Substitution
     */
    private Substitution substitution;

    /**
     * Substitution Reason
     */
    private SubstitutionReason substitutionReason;

    /**
     * Dosage Instruction
     */
    private DosageInstruction dosageInstruction;

    public PrescribedMedication() {
    }

}
