package org.celllife.idart.client.medication;

import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.common.SystemId;
import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.PartClassificationCode;
import org.celllife.idart.common.PartClassificationType;

import static org.celllife.idart.common.FormCode.formCode;
import static org.celllife.idart.common.Identifiers.newIdentifier;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class DrugBuilder {

    private final Drug drug;

    private final String clinicDrugsidentifiersystem;

    public DrugBuilder(String clinicId) {
        this.drug = new Drug();
        this.clinicDrugsidentifiersystem =
                String.format("http://www.cell-life.org/idart/clinics/%s/drugs", clinicId);
    }

    public DrugBuilder setId(String idValue) {
        this.drug.identifiers.add(newIdentifier(idValue));
        return this;
    }

    public DrugBuilder setIdentifier(SystemId system, String idValue) {
        this.drug.identifiers.add(newIdentifier(system, idValue));
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
        this.drug.form = formCode(formCodeValue);
        return this;
    }

    public DrugBuilder addClassification(PartClassificationType type, String classificationCode) {
        PartClassificationCode code = new PartClassificationCode();
        code.setType(type);
        code.setValue(classificationCode);
        this.drug.classifications.add(code);
        return this;
    }
}
