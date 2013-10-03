package org.celllife.idart.client.dispensation;

import org.celllife.idart.client.dosageinstruction.DosageInstruction;
import org.celllife.idart.common.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.Identifiers.newIdentifiers;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h53
 */
public final class DispensedMedicationBuilder implements Serializable {

    private DispensedMedication dispensedMedication;

    private SystemId systemId;

    public DispensedMedicationBuilder(String systemId) {
        this.dispensedMedication = new DispensedMedication();
        this.systemId = SystemId.systemId(systemId);
    }

    public DispensedMedicationBuilder setMedication(String id) {

        HashSet<Identifier> medication = new HashSet<Identifier>();
        medication.add(newIdentifier(systemId, id));
        this.dispensedMedication.setMedication(medication);

        return this;
    }

    public DispensedMedicationBuilder setQuantity(Quantity quantity) {
        this.dispensedMedication.setQuantity(quantity);
        return this;
    }

    public DispensedMedicationBuilder setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.dispensedMedication.setExpectedSupplyDuration(expectedSupplyDuration);
        return this;
    }

    public DispensedMedicationBuilder setExpectedSupplyDuration(int quantity, UnitOfMeasureCode unitOfMeasure) {
        Duration expectedSupplyDuration = new Duration();
        expectedSupplyDuration.setValue(new BigDecimal(quantity));
        expectedSupplyDuration.setUnitOfMeasure(unitOfMeasure);

        this.dispensedMedication.setExpectedSupplyDuration(expectedSupplyDuration);

        return this;
    }

    public DispensedMedicationBuilder setDosageInstruction(DosageInstruction dosageInstruction) {
        this.dispensedMedication.setDosageInstruction(dosageInstruction);
        return this;
    }

    public DispensedMedicationBuilder setDosageQuantity(double quantity, UnitOfMeasureCode unitOfMeasure) {

        Quantity doseQuantity = new Quantity();
        doseQuantity.setValue(new BigDecimal(quantity));
        doseQuantity.setUnitOfMeasure(unitOfMeasure);

        getDosageInstructions().setDoseQuantity(doseQuantity);

        return this;
    }

    public DispensedMedicationBuilder repeat(int frequency) {
        getRepeat().setFrequency(frequency);
        return this;
    }

    public DispensedMedicationBuilder every(int quantity, UnitOfMeasureCode unitOfMeasure) {
        Duration duration = new Duration();
        duration.setValue(new BigDecimal(quantity));
        duration.setUnitOfMeasure(unitOfMeasure);
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

    public DispensedMedication finishDispensedMedication() {
        return dispensedMedication;
    }

    private DosageInstruction getDosageInstructions() {
        if (dispensedMedication.getDosageInstruction() == null) {
            dispensedMedication.setDosageInstruction(new DosageInstruction());
        }
        return dispensedMedication.getDosageInstruction();
    }

    public DispensedMedicationBuilder setAuthorizingPrescribedMedication(String authorizingPrescribedMedication) {
        this.dispensedMedication.setAuthorizingPrescribedMedication(newIdentifiers(systemId, authorizingPrescribedMedication));
        return this;
    }
}
