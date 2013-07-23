package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class CompoundBuilder {

    private final Drug drug;

    private final String clinicDrugsIdentifierSystem;

    public CompoundBuilder(String clinicIdentifier) {
        this.drug = new Drug();
        this.clinicDrugsIdentifierSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicIdentifier);
    }

    public CompoundBuilder setIdentifier(String identifierValue) {
        this.drug.identifiers.add(new Identifier(this.clinicDrugsIdentifierSystem, identifierValue));
        return this;
    }

    public CompoundBuilder setIdentifier(String identifierSystem, String identifierValue) {
        this.drug.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public Drug finishDrug() {
        return drug;
    }

    public CompoundBuilder addBillOfMaterialsItem(PartBillOfMaterialsItem partBillOfMaterialsItem) {
        drug.billOfMaterials.add(partBillOfMaterialsItem);
        return this;
    }

    public CompoundBuilder setForm(String formCodeSystem, String formCodeValue) {
        this.drug.form = new Form();
        this.drug.form.codes.add(new Code(formCodeSystem, formCodeValue));
        return this;
    }
}
