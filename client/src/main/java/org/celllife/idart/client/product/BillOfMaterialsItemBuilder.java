package org.celllife.idart.client.product;

import org.celllife.idart.client.part.EngineeringPartBillOfMaterialsItem;
import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.Quantity;
import org.celllife.idart.common.UnitOfMeasureCode;

import java.math.BigDecimal;
import java.util.Set;

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

    public BillOfMaterialsItemBuilder setQuantity(int quantity, UnitOfMeasureCode unitOfMeasure) {
        Quantity quantityUsed = new Quantity();
        quantityUsed.setValue(new BigDecimal(quantity));
        quantityUsed.setUnitOfMeasure(unitOfMeasure);

        this.engineeringPartBillOfMaterialsItem.setQuantityUsed(quantityUsed);
        return this;
    }

    public PartBillOfMaterialsItem finishBillOfMaterialsItem() {
        return engineeringPartBillOfMaterialsItem;
    }

    public BillOfMaterialsItemBuilder addPart(Set<Identifier> part) {
        this.engineeringPartBillOfMaterialsItem.setPart(part);
        return this;
    }
}
