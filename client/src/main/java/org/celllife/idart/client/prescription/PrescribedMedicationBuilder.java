package org.celllife.idart.client.prescription;

import org.celllife.idart.common.*;
import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.client.indication.Indication;
import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.substitution.Substitution;
import org.celllife.idart.client.substitutionreason.SubstitutionReason;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class PrescribedMedicationBuilder implements Serializable {

    private PrescribedMedication prescribedMedication;

    private SystemId systemId;

    public PrescribedMedicationBuilder(String systemId) {
        this.prescribedMedication = new PrescribedMedication();
        this.systemId = SystemId.systemId(systemId);
    }

    public PrescribedMedicationBuilder setId(String prescribedMedicationId) {
        this.prescribedMedication.getIdentifiers().add(newIdentifier(systemId, prescribedMedicationId));
        return this;
    }

    public PrescribedMedicationBuilder setMedication(String id) {

        HashSet<Identifier> medication = new HashSet<Identifier>();
        medication.add(newIdentifier(systemId, id));
        this.prescribedMedication.setMedication(medication);

        return this;
    }

    public PrescribedMedicationBuilder setReasonForPrescribing(String reasonForPrescribing) {
        this.prescribedMedication.setReasonForPrescribing(reasonForPrescribing);
        return this;
    }

    public PrescribedMedicationBuilder setIndications(Set<Indication> indications) {
        this.prescribedMedication.setIndications(indications);
        return this;
    }

    public PrescribedMedicationBuilder setValid(Date fromDate, Date thruDate) {

        Period valid = new Period();
        valid.setFromDate(fromDate);
        valid.setThruDate(thruDate);

        this.prescribedMedication.setValid(valid);
        return this;
    }

    public PrescribedMedicationBuilder setNumberOfRepeats(Integer numberOfRepeats) {
        this.prescribedMedication.setNumberOfRepeats(numberOfRepeats);
        return this;
    }

    public PrescribedMedicationBuilder setQuantity(Quantity quantity) {
        this.prescribedMedication.setQuantity(quantity);
        return this;
    }

    public PrescribedMedicationBuilder setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.prescribedMedication.setExpectedSupplyDuration(expectedSupplyDuration);
        return this;
    }

    public PrescribedMedicationBuilder setExpectedSupplyDuration(int quantity, String uomCodeValue) {
        Duration expectedSupplyDuration = new Duration();
        expectedSupplyDuration.setValue(new BigDecimal(quantity));
        expectedSupplyDuration.setUnitOfMeasure(unitOfMeasureCode(uomCodeValue));

        this.prescribedMedication.setExpectedSupplyDuration(expectedSupplyDuration);

        return this;
    }

    public PrescribedMedicationBuilder setSubstitution(Substitution substitution) {
        this.prescribedMedication.setSubstitution(substitution);
        return this;
    }

    public PrescribedMedicationBuilder setSubstitutionReason(SubstitutionReason substitutionReason) {
        this.prescribedMedication.setSubstitutionReason(substitutionReason);
        return this;
    }

    public PrescribedMedicationBuilder setDosageInstruction(DosageInstruction dosageInstruction) {
        this.prescribedMedication.setDosageInstruction(dosageInstruction);
        return this;
    }

    public PrescribedMedicationBuilder setDosageQuantity(double quantity, String uomCodeValue) {

        Quantity doseQuantity = new Quantity();
        doseQuantity.setValue(new BigDecimal(quantity));
        doseQuantity.setUnitOfMeasure(unitOfMeasureCode(uomCodeValue));

        getDosageInstructions().setDoseQuantity(doseQuantity);

        return this;
    }

    public PrescribedMedicationBuilder repeat(int frequency) {
        getRepeat().setFrequency(frequency);
        return this;
    }

    public PrescribedMedicationBuilder every(int quantity, String uomCodeValue) {
        Duration duration = new Duration();
        duration.setValue(new BigDecimal(quantity));
        duration.setUnitOfMeasure(unitOfMeasureCode(uomCodeValue));
        getRepeat().setDuration(duration);
        return this;
    }

    private Repeat getRepeat() {
        if (getTiming().getRepeat() == null) {
            getTiming().setRepeat(new Repeat());
        }
        return getTiming().getRepeat();
    }

    private Schedule getTiming() {
        if (getDosageInstructions().getTiming() == null) {
            getDosageInstructions().setTiming(new Schedule());
        }
        return getDosageInstructions().getTiming();
    }

    public PrescribedMedication finishPrescribedMedication() {
        return prescribedMedication;
    }

    private DosageInstruction getDosageInstructions() {
        if (prescribedMedication.getDosageInstruction() == null) {
            prescribedMedication.setDosageInstruction(new DosageInstruction());
        }
        return prescribedMedication.getDosageInstruction();
    }
}
