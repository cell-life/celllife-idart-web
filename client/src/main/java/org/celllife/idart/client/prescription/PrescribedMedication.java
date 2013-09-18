package org.celllife.idart.client.prescription;

import org.celllife.idart.common.Duration;
import org.celllife.idart.common.Period;
import org.celllife.idart.common.Quantity;
import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.client.indication.Indication;
import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.substitution.Substitution;
import org.celllife.idart.client.substitutionreason.SubstitutionReason;
import org.celllife.idart.common.Identifier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class PrescribedMedication implements Serializable {

    private Set<Identifier> identifiers = new HashSet<Identifier>();

    private Set<Identifier> medication;

    private String reasonForPrescribing;

    private Set<Indication> indications;

    private Period valid;

    private Integer numberOfRepeats;

    private Quantity quantity;

    private Duration expectedSupplyDuration;

    private Substitution substitution;

    private SubstitutionReason substitutionReason;

    private DosageInstruction dosageInstruction;

    public PrescribedMedication() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Set<Identifier> getMedication() {
        return medication;
    }

    public void setMedication(Set<Identifier> medication) {
        this.medication = medication;
    }

    public String getReasonForPrescribing() {
        return reasonForPrescribing;
    }

    public void setReasonForPrescribing(String reasonForPrescribing) {
        this.reasonForPrescribing = reasonForPrescribing;
    }

    public Set<Indication> getIndications() {
        return indications;
    }

    public void setIndications(Set<Indication> indications) {
        this.indications = indications;
    }

    public Period getValid() {
        return valid;
    }

    public void setValid(Period valid) {
        this.valid = valid;
    }

    public Integer getNumberOfRepeats() {
        return numberOfRepeats;
    }

    public void setNumberOfRepeats(Integer numberOfRepeats) {
        this.numberOfRepeats = numberOfRepeats;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Duration getExpectedSupplyDuration() {
        return expectedSupplyDuration;
    }

    public void setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.expectedSupplyDuration = expectedSupplyDuration;
    }

    public Substitution getSubstitution() {
        return substitution;
    }

    public void setSubstitution(Substitution substitution) {
        this.substitution = substitution;
    }

    public SubstitutionReason getSubstitutionReason() {
        return substitutionReason;
    }

    public void setSubstitutionReason(SubstitutionReason substitutionReason) {
        this.substitutionReason = substitutionReason;
    }

    public DosageInstruction getDosageInstruction() {
        return dosageInstruction;
    }

    public void setDosageInstruction(DosageInstruction dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }
}
