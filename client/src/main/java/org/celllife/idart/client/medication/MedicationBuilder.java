package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 19h30
 */
public final class MedicationBuilder {

    private final Medication medication;

    private final String clinicMedicationsIdentifierSystem;

    private final String clinicDrugsIdentifierSystem;

    public MedicationBuilder(String clinicIdentifier) {
        this.medication = new Medication();
        this.medication.drug = new Drug();

        this.clinicMedicationsIdentifierSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/medications", clinicIdentifier);

        this.clinicDrugsIdentifierSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicIdentifier);

    }

    public MedicationBuilder setIdentifier(String identifier) {
        this.medication.identifiers.add(new Identifier(clinicMedicationsIdentifierSystem, identifier));
        this.medication.drug = new Drug();
        this.medication.drug.identifiers.add(new Identifier(clinicDrugsIdentifierSystem, identifier));
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
