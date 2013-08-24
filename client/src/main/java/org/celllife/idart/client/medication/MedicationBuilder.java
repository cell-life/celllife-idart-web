package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Id;
import org.celllife.idart.client.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 19h30
 */
public final class MedicationBuilder {

    private final Medication medication;

    private final String clinicMedicationsIdSystem;

    private final String clinicDrugsIdSystem;

    public MedicationBuilder(String clinicId) {
        this.medication = new Medication();
        this.medication.drug = new Drug();

        this.clinicMedicationsIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/medications", clinicId);

        this.clinicDrugsIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicId);

    }

    public MedicationBuilder setId(String id) {
        this.medication.ids.add(new Id(clinicMedicationsIdSystem, id));
        this.medication.drug = new Drug();
        this.medication.drug.ids.add(new Id(clinicDrugsIdSystem, id));
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
