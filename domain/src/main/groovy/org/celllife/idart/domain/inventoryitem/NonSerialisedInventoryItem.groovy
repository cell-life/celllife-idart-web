package org.celllife.idart.domain.inventoryitem

import org.celllife.idart.common.Quantity

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h49
 */
class NonSerialisedInventoryItem extends InventoryItem {

    @NotNull
    Quantity quantityOnHand

}
