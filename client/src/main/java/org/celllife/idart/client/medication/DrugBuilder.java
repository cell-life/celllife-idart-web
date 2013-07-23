package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class DrugBuilder {

    private final Drug drug;

    private final MedicationBuilder parent;

    private final Medication medication;

    private final String clinicIdentifier;

    private final String clinicDrugsIdentifierSystem;

    public DrugBuilder(MedicationBuilder parent, Medication medication, String clinicIdentifier) {
        this.drug = new Drug();
        this.parent = parent;
        this.medication = medication;
        this.clinicIdentifier = clinicIdentifier;
        this.clinicDrugsIdentifierSystem =
                String.format("http://www.celllife.org/idart/clinics/%s/drugs", clinicIdentifier);
    }

    public DrugBuilder setIdentifier(String identifier) {
        this.drug.identifiers.add(new Identifier(this.clinicDrugsIdentifierSystem, identifier));
        return this;
    }

    public MedicationBuilder finishDrug() {
        medication.drug = drug;
        return parent;
    }

    public BillOfMaterialsItemBuilder createBillOfMaterialsItem() {
        return new BillOfMaterialsItemBuilder(this, drug, clinicIdentifier);
    }
}
