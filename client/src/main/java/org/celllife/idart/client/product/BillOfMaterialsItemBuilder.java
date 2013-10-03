package org.celllife.idart.client.product;

import org.celllife.idart.client.part.PartBillOfMaterialsItem;
import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.PartBillOfMaterialsType;
import org.celllife.idart.common.Quantity;
import org.celllife.idart.common.UnitOfMeasureCode;

import java.math.BigDecimal;
import java.util.Set;

import static org.celllife.idart.common.PartBillOfMaterialsType.ENGINEERING;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-23
 * Time: 21h05
 */
public class BillOfMaterialsItemBuilder {

    private final PartBillOfMaterialsItem partBillOfMaterialsItem;

    public BillOfMaterialsItemBuilder() {
        this.partBillOfMaterialsItem = new PartBillOfMaterialsItem();
        this.partBillOfMaterialsItem.setType(ENGINEERING);
    }

    public BillOfMaterialsItemBuilder setQuantity(int quantity, UnitOfMeasureCode unitOfMeasure) {
        Quantity quantityUsed = new Quantity();
        quantityUsed.setValue(new BigDecimal(quantity));
        quantityUsed.setUnitOfMeasure(unitOfMeasure);

        this.partBillOfMaterialsItem.setQuantityUsed(quantityUsed);
        return this;
    }

    public PartBillOfMaterialsItem finishBillOfMaterialsItem() {
        return partBillOfMaterialsItem;
    }

    public BillOfMaterialsItemBuilder addPart(Set<Identifier> part) {
        this.partBillOfMaterialsItem.setPart(part);
        return this;
    }
}
