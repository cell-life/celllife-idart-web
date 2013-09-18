package org.celllife.idart.client.medication;

import org.celllife.idart.client.part.EngineeringPartBillOfMaterialsItem;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.common.Quantity;

import java.math.BigDecimal;

import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 21h05
 */
public class BillOfMaterialsItemBuilder {

    private final EngineeringPartBillOfMaterialsItem engineeringPartBillOfMaterialsItem;

    public BillOfMaterialsItemBuilder() {
        this.engineeringPartBillOfMaterialsItem = new EngineeringPartBillOfMaterialsItem();
    }

    public BillOfMaterialsItemBuilder setQuantity(int quantity, String uomCodeValue) {
        Quantity quantityUsed = new Quantity();
        quantityUsed.setValue(new BigDecimal(quantity));
        quantityUsed.setUnitOfMeasure(unitOfMeasureCode(uomCodeValue));

        this.engineeringPartBillOfMaterialsItem.setQuantityUsed(quantityUsed);
        return this;
    }

    public PartBillOfMaterialsItem finishBillOfMaterialsItem() {
        return engineeringPartBillOfMaterialsItem;
    }

    public BillOfMaterialsItemBuilder addPart(Part part) {
        this.engineeringPartBillOfMaterialsItem.setPart(part);
        return this;
    }
}
