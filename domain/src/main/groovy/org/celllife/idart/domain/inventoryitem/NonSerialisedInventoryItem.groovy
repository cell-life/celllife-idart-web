package org.celllife.idart.domain.inventoryitem

import groovy.transform.ToString

import javax.validation.constraints.NotNull

import org.celllife.idart.common.Quantity

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h49
 */
@ToString
class NonSerialisedInventoryItem extends InventoryItem {

    @NotNull
    Quantity quantityOnHand

}
