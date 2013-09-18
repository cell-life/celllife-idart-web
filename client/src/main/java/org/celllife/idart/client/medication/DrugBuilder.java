package org.celllife.idart.client.medication;

import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.common.PartClassificationCode;
import org.celllife.idart.common.PartClassificationType;
import org.celllife.idart.common.SystemId;

import static org.celllife.idart.common.FormCode.formCode;
import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 20h54
 */
public class DrugBuilder {

    private final Drug drug;

    private final SystemId systemId;

    public DrugBuilder(String systemId) {
        this.drug = new Drug();
        this.systemId = systemId(systemId);
    }

    public DrugBuilder setIdentifier(String idValue) {
        this.drug.getIdentifiers().add(newIdentifier(systemId, idValue));
        return this;
    }

    public DrugBuilder setIdentifier(SystemId system, String idValue) {
        this.drug.getIdentifiers().add(newIdentifier(system, idValue));
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
        this.drug.setForm(formCode(formCodeValue));
        return this;
    }

    public DrugBuilder addClassification(PartClassificationType type, String classificationCode) {
        PartClassificationCode code = new PartClassificationCode();
        code.setType(type);
        code.setValue(classificationCode);
        this.drug.getClassifications().add(code);
        return this;
    }
}
