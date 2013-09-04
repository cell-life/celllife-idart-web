package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.*;
import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.client.indication.Indication;
import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.substitution.Substitution;
import org.celllife.idart.client.substitutionreason.SubstitutionReason;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class PrescribedMedicationBuilder implements Serializable {

    private PrescribedMedication prescribedMedication;

    private String clinicMedicationsIdSystem;

    private String clinicPrescribedMedicationsIdSystem;

    public PrescribedMedicationBuilder(String clinicId) {
        this.prescribedMedication = new PrescribedMedication();
        this.clinicMedicationsIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/medications", clinicId);
        this.clinicPrescribedMedicationsIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/prescribedMedications", clinicId);
    }

    public PrescribedMedicationBuilder setId(String prescribedMedicationId) {
        this.prescribedMedication.ids.add(new Id(prescribedMedicationId));
        return this;
    }

    public PrescribedMedicationBuilder setMedication(String id) {
        this.prescribedMedication.medication = new Medication();
        this.prescribedMedication.medication.ids.add(new Id(id));
        return this;
    }

    public PrescribedMedicationBuilder setReasonForPrescribing(String reasonForPrescribing) {
        this.prescribedMedication.reasonForPrescribing = reasonForPrescribing;
        return this;
    }

    public PrescribedMedicationBuilder setIndications(Set<Indication> indications) {
        this.prescribedMedication.indications = indications;
        return this;
    }

    public PrescribedMedicationBuilder setValid(Date fromDate, Date thruDate) {
        this.prescribedMedication.valid = new Period();
        this.prescribedMedication.valid.fromDate = fromDate;
        this.prescribedMedication.valid.thruDate = thruDate;
        return this;
    }

    public PrescribedMedicationBuilder setNumberOfRepeats(Integer numberOfRepeats) {
        this.prescribedMedication.numberOfRepeats = numberOfRepeats;
        return this;
    }

    public PrescribedMedicationBuilder setQuantity(Quantity quantity) {
        this.prescribedMedication.quantity = quantity;
        return this;
    }

    public PrescribedMedicationBuilder setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.prescribedMedication.expectedSupplyDuration = expectedSupplyDuration;
        return this;
    }

    public PrescribedMedicationBuilder setExpectedSupplyDuration(int quantity, String uomCodeValue) {
        this.prescribedMedication.expectedSupplyDuration = new Duration();
        this.prescribedMedication.expectedSupplyDuration.value = new BigDecimal(quantity);
        this.prescribedMedication.expectedSupplyDuration.unitOfMeasure = new UnitOfMeasure(uomCodeValue);
        return this;
    }

    public PrescribedMedicationBuilder setSubstitution(Substitution substitution) {
        this.prescribedMedication.substitution = substitution;
        return this;
    }

    public PrescribedMedicationBuilder setSubstitutionReason(SubstitutionReason substitutionReason) {
        this.prescribedMedication.substitutionReason = substitutionReason;
        return this;
    }

    public PrescribedMedicationBuilder setDosageInstruction(DosageInstruction dosageInstruction) {
        this.prescribedMedication.dosageInstruction = dosageInstruction;
        return this;
    }

    public PrescribedMedicationBuilder setDosageQuantity(double quantity, String uomCodeValue) {
        DosageInstruction dosageInstruction = getDosageInstructions();
        dosageInstruction.doseQuantity = new Quantity();
        dosageInstruction.doseQuantity.value = new BigDecimal(quantity);
        dosageInstruction.doseQuantity.unitOfMeasure = new UnitOfMeasure(uomCodeValue);
        return this;
    }

    public PrescribedMedicationBuilder repeat(int frequency) {
        getRepeat().frequency = frequency;
        return this;
    }

    public PrescribedMedicationBuilder every(int quantity, String uomCodeValue) {
        getRepeat().duration = new Duration();
        getRepeat().duration.value = new BigDecimal(quantity);
        getRepeat().duration.unitOfMeasure = new UnitOfMeasure(uomCodeValue);
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

    public PrescribedMedication finishPrescribedMedication() {
        return prescribedMedication;
    }

    private DosageInstruction getDosageInstructions() {
        if (prescribedMedication.dosageInstruction == null) {
            prescribedMedication.dosageInstruction = new DosageInstruction();
        }
        return prescribedMedication.dosageInstruction;
    }
}
