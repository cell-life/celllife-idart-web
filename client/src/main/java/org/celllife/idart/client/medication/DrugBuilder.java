package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.client.part.PartClassification;
import org.celllife.idart.client.part.PartClassificationType;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class DrugBuilder {

    private final Drug drug;

    private final String clinicDrugsIdentifierSystem;

    public DrugBuilder(String clinicIdentifier) {
        this.drug = new Drug();
        this.clinicDrugsIdentifierSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicIdentifier);
    }

    public DrugBuilder setIdentifier(String identifierValue) {
        this.drug.identifiers.add(new Identifier(this.clinicDrugsIdentifierSystem, identifierValue));
        return this;
    }

    public DrugBuilder setIdentifier(String identifierSystem, String identifierValue) {
        this.drug.identifiers.add(new Identifier(identifierSystem, identifierValue));
        return this;
    }

    public Drug finishDrug() {
        return drug;
    }

    public DrugBuilder addBillOfMaterialsItem(PartBillOfMaterialsItem partBillOfMaterialsItem) {
        drug.billOfMaterials.add(partBillOfMaterialsItem);
        return this;
    }

    public DrugBuilder setForm(String formCodeSystem, String formCodeValue) {
        this.drug.form = new Form();
        this.drug.form.codes.add(new Code(formCodeSystem, formCodeValue));
        return this;
    }

    public DrugBuilder addClassification(PartClassificationType type, String classificationCode) {
        this.drug.classifications.add(new PartClassification(type, classificationCode));
        return this;
    }
}
