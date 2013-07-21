package org.celllife.idart.domain.inventoryitem

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h48
 */
class SerialisedInventoryItem extends InventoryItem {

    @NotNull
    String serialNumber

}
