package org.celllife.idart.domain.inventoryitem

import org.celllife.idart.domain.common.ValueObject

import javax.persistence.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h53
 */
@Embeddable
class InventoryItemStatus implements ValueObject {

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime

    @Enumerated(EnumType.STRING)
    private InventoryItemStatusType statusType

    InventoryItemStatus() {
    }

    InventoryItemStatus(Date dateTime, InventoryItemStatusType statusType) {
        this.dateTime = dateTime
        this.statusType = statusType
    }

    Date getDateTime() {
        return dateTime
    }

    void setDateTime(Date dateTime) {
        this.dateTime = dateTime
    }

    InventoryItemStatusType getStatusType() {
        return statusType
    }

    void setStatusType(InventoryItemStatusType statusType) {
        this.statusType = statusType
    }
}
