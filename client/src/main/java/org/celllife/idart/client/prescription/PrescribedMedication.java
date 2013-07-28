package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.Duration;
import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.common.Period;
import org.celllife.idart.client.common.Quantity;
import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.client.indication.Indication;
import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.substitution.Substitution;
import org.celllife.idart.client.substitutionreason.SubstitutionReason;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class PrescribedMedication implements Serializable {

    public Set<Identifier> identifiers = new HashSet<Identifier>();

    public Medication medication;

    public String reasonForPrescribing;

    public Set<Indication> indications;

    public Period valid;

    public Integer numberOfRepeats;

    public Quantity quantity;

    public Duration expectedSupplyDuration;

    public Substitution substitution;

    public SubstitutionReason substitutionReason;

    public DosageInstruction dosageInstruction;

    public PrescribedMedication() {
    }
}
