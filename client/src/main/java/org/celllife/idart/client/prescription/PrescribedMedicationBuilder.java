package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.*;
import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.client.good.Medication;
import org.celllife.idart.client.indication.Indication;
import org.celllife.idart.client.substitution.Substitution;
import org.celllife.idart.client.substitutionreason.SubstitutionReason;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class PrescribedMedicationBuilder implements Serializable {

    private PrescribedMedication prescribedMedication;

    private PrescriptionBuilder parent;

    private Prescription prescription;

    public PrescribedMedicationBuilder(PrescriptionBuilder parent, Prescription prescription) {
        this.prescribedMedication = new PrescribedMedication();
        this.parent = parent;
        this.prescription = prescription;
    }

    public PrescribedMedicationBuilder setMedication(String identifier) {
        prescribedMedication.medication = new Medication();
        prescribedMedication.medication.identifiers.add(new Identifier("http://www.celllife.org/idart/medications", identifier));
        return this;
    }

    public PrescribedMedicationBuilder setReasonForPrescribing(String reasonForPrescribing) {
        prescribedMedication.reasonForPrescribing = reasonForPrescribing;
        return this;
    }

    public PrescribedMedicationBuilder setIndications(Set<Indication> indications) {
        prescribedMedication.indications = indications;
        return this;
    }

    public PrescribedMedicationBuilder setValid(Period valid) {
        prescribedMedication.valid = valid;
        return this;
    }

    public PrescribedMedicationBuilder setNumberOfRepeats(Integer numberOfRepeats) {
        prescribedMedication.numberOfRepeats = numberOfRepeats;
        return this;
    }

    public PrescribedMedicationBuilder setQuantity(Quantity quantity) {
        prescribedMedication.quantity = quantity;
        return this;
    }

    public PrescribedMedicationBuilder setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        prescribedMedication.expectedSupplyDuration = expectedSupplyDuration;
        return this;
    }

    public PrescribedMedicationBuilder setSubstitution(Substitution substitution) {
        prescribedMedication.substitution = substitution;
        return this;
    }

    public PrescribedMedicationBuilder setSubstitutionReason(SubstitutionReason substitutionReason) {
        prescribedMedication.substitutionReason = substitutionReason;
        return this;
    }

    public PrescribedMedicationBuilder setDosageInstruction(DosageInstruction dosageInstruction) {
        prescribedMedication.dosageInstruction = dosageInstruction;
        return this;
    }

    public PrescribedMedicationBuilder setDosageQuantity(int quantity, String uomCodeSystem, String uomCodeValue) {
        DosageInstruction dosageInstruction = getDosageInstructions();
        dosageInstruction.doseQuantity = new Quantity();
        dosageInstruction.doseQuantity.value = new BigDecimal(quantity);
        dosageInstruction.doseQuantity.unitOfMeasure = new UnitOfMeasure(uomCodeSystem, uomCodeValue);
        return this;
    }

    public PrescribedMedicationBuilder repeat(int frequency) {
        getRepeat().frequency = frequency;
        return this;
    }

    public PrescribedMedicationBuilder every(int quantity, String uomCodeSystem, String uomCodeValue) {
        getRepeat().duration = new Duration();
        getRepeat().duration.value = new BigDecimal(quantity);
        getRepeat().duration.unitOfMeasure = new UnitOfMeasure(uomCodeSystem, uomCodeValue);
        return this;
    }

    private Repeat getRepeat() {
        if (getTiming().repeat == null) {
            getTiming().repeat = new Repeat();
        }
        return getTiming().repeat;
    }

    private Schedule getTiming() {
        if (getDosageInstructions().timing == null) {
            getDosageInstructions().timing = new Schedule();
        }
        return getDosageInstructions().timing;
    }

    public PrescriptionBuilder finishPrescribedMedication() {
        prescription.prescribedMedications.add(prescribedMedication);
        return parent;
    }

    private DosageInstruction getDosageInstructions() {
        if (prescribedMedication.dosageInstruction == null) {
            prescribedMedication.dosageInstruction = new DosageInstruction();
        }
        return prescribedMedication.dosageInstruction;
    }
}
