package org.celllife.idart.client.part;

import static org.celllife.idart.common.FormCode.formCode;
import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.SystemId.systemId;

import java.math.BigDecimal;

import org.celllife.idart.common.Label;
import org.celllife.idart.common.PartClassificationCode;
import org.celllife.idart.common.PartClassificationType;
import org.celllife.idart.common.Quantity;
import org.celllife.idart.common.SystemId;
import org.celllife.idart.common.UnitOfMeasureCode;

/**
 * Handy class that allows you to build a Drug object. Like so:
 * <pre>
           Drug pills = new DrugBuilder(clinicId)
                .setIdentifier("00000001")
                .setForm("CAP")
                .setLabel(label("Abacavir 300mg (60 capsules)"))
                .setQuantity(60, UnitsOfMeasure.each.code)
                .addClassification(PartClassificationType.ATC, "J05AF06")
                .addBillOfMaterialsItem(new BillOfMaterialsItemBuilder()
                        .setQuantity(300, UnitsOfMeasure.mL.code)
                        .addPart(pill.getIdentifiers())
                        .finishBillOfMaterialsItem()
                )
                .finishDrug();
 * </pre>
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
    
    public DrugBuilder setQuantity(int quantity, UnitOfMeasureCode unitOfMeasure) {
        Quantity quantityObj = new Quantity();
        quantityObj.setValue(new BigDecimal(quantity));
        quantityObj.setUnitOfMeasure(unitOfMeasure);
        this.drug.setQuantity(quantityObj);
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
