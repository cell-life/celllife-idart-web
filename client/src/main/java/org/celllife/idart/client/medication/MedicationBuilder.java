package org.celllife.idart.client.medication;

import org.celllife.idart.client.part.Drug;
import org.celllife.idart.common.SystemId;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 19h30
 */
public final class MedicationBuilder {

    private final Medication medication;

    private final SystemId systemId;

    public MedicationBuilder(String systemId) {
        this.medication = new Medication();
        this.medication.drug = new Drug();
        this.systemId = systemId(systemId);

    }

    public MedicationBuilder setIdentifier(String id) {
        this.medication.identifiers.add(newIdentifier(systemId, id));
        this.medication.drug = new Drug();
        this.medication.drug.getIdentifiers().add(newIdentifier(systemId, id));
        return this;
    }

    public MedicationBuilder setName(String name) {
        this.medication.name = name;
        return this;
    }

    public Medication finishMedication() {
        return medication;
    }

    public MedicationBuilder addDrug(Drug drug) {
        this.medication.drug = drug;
        return this;
    }
}
