package org.celllife.idart.domain.inventoryitem

import org.celllife.idart.domain.common.Quantity

import javax.persistence.AssociationOverride
import javax.persistence.AttributeOverride
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h49
 */
class NonSerialisedInventoryItem extends InventoryItem {

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "quantityOnHand"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "quantityOnHandUom"))
    private Quantity quantityOnHand

    NonSerialisedInventoryItem() {
    }

    Quantity getQuantityOnHand() {
        return quantityOnHand
    }

    void setQuantityOnHand(Quantity quantityOnHand) {
        this.quantityOnHand = quantityOnHand
    }
}
