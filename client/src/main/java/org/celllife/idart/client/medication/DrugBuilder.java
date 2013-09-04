package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.Id;
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

    private final String clinicDrugsIdSystem;

    public DrugBuilder(String clinicId) {
        this.drug = new Drug();
        this.clinicDrugsIdSystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicId);
    }

    public DrugBuilder setId(String idValue) {
        this.drug.ids.add(new Id(idValue));
        return this;
    }

    public DrugBuilder setId(String idSystem, String idValue) {
        this.drug.ids.add(new Id(idValue));
        return this;
    }

    public Drug finishDrug() {
        return drug;
    }

    public DrugBuilder addBillOfMaterialsItem(PartBillOfMaterialsItem partBillOfMaterialsItem) {
        drug.billOfMaterials.add(partBillOfMaterialsItem);
        return this;
    }

    public DrugBuilder setForm(String formCodeValue) {
        this.drug.form = new Form();
        this.drug.form.codes.add(new Code(formCodeValue));
        return this;
    }

    public DrugBuilder addClassification(PartClassificationType type, String classificationCode) {
        this.drug.classifications.add(new PartClassification(type, classificationCode));
        return this;
    }
}
