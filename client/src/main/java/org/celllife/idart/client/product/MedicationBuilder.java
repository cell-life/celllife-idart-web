package org.celllife.idart.client.product;

import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.SystemId;

import java.util.Set;

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
        this.systemId = systemId(systemId);

    }

    public MedicationBuilder setIdentifier(String identifier) {
        this.medication.getIdentifiers().add(newIdentifier(systemId, identifier));
        return this;
    }

    public MedicationBuilder setName(String name) {
        this.medication.setName(name);
        return this;
    }

    public Medication finishMedication() {
        return medication;
    }

    public MedicationBuilder addDrug(Set<Identifier> drug) {
        this.medication.setDrug(drug);
        return this;
    }
}
