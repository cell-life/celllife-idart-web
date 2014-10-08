package org.celllife.idart.domain.inventoryitem

import groovy.transform.ToString

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h53
 */
@ToString
class InventoryItemStatus implements Serializable {

    Date dateTime

    InventoryItemStatusType statusType

}
