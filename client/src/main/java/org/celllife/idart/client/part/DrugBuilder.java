package org.celllife.idart.client.part;

import org.celllife.idart.common.Label;
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

    public DrugBuilder setIdentifier(String identifier) {
        this.drug.getIdentifiers().add(newIdentifier(systemId, identifier));
        return this;
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
        this.drug.getClassifications().add(new PartClassificationApplication(code));
        return this;
    }

    public DrugBuilder setLabel(Label label) {
        this.drug.setLabel(label);
        return this;
    }

    public Drug finishDrug() {
        return drug;
    }
}
