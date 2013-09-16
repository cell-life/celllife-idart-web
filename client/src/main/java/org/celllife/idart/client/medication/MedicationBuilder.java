package org.celllife.idart.client.medication;

import org.celllife.idart.common.Id;
import org.celllife.idart.client.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 19h30
 */
public final class MedicationBuilder {

    private final Medication medication;

    private final String clinicMedicationsidentifiersystem;

    private final String clinicDrugsidentifiersystem;

    public MedicationBuilder(String clinicId) {
        this.medication = new Medication();
        this.medication.drug = new Drug();

        this.clinicMedicationsidentifiersystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/medications", clinicId);

        this.clinicDrugsidentifiersystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicId);

    }

    public MedicationBuilder setId(String id) {
        this.medication.identifiers.add(newIdentifier(id));
        this.medication.drug = new Drug();
        this.medication.drug.identifiers.add(newIdentifier(id));
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
