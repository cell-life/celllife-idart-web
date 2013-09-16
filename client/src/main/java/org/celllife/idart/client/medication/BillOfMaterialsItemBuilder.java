package org.celllife.idart.client.medication;

import org.celllife.idart.common.Quantity;
import org.celllife.idart.client.part.EngineeringPartBillOfMaterialsItem;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

import java.math.BigDecimal;

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
        this.engineeringPartBillOfMaterialsItem.quantityUsed = new Quantity();
        this.engineeringPartBillOfMaterialsItem.quantityUsed.value = new BigDecimal(quantity);
        this.engineeringPartBillOfMaterialsItem.quantityUsed.unitOfMeasure = new UnitOfMeasure(uomCodeValue);
        return this;
    }

    public PartBillOfMaterialsItem finishBillOfMaterialsItem() {
        return engineeringPartBillOfMaterialsItem;
    }

    public BillOfMaterialsItemBuilder addPart(Part part) {
        this.engineeringPartBillOfMaterialsItem.part = part;
        return this;
    }
}
