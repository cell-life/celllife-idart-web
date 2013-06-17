package org.celllife.idart.udm.inventoryitem;

import org.celllife.idart.udm.common.Quantity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h49
 */
@Entity
public final class NonSerialisedInventoryItem extends InventoryItem {

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "quantityOnHand"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "quantityOnHandUom"))
    private Quantity quantityOnHand;

    public NonSerialisedInventoryItem() {
    }

    public Quantity getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Quantity quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
