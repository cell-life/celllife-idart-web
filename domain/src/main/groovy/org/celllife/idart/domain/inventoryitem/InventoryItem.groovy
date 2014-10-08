package org.celllife.idart.domain.inventoryitem

import groovy.transform.ToString

import org.celllife.idart.common.PartId

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h47
 */
@ToString
abstract class InventoryItem implements Serializable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * the physical occurrence of
     */
    PartId part

    List<InventoryItemStatus> status = []

}
