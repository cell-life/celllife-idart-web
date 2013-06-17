package org.celllife.idart.udm.inventoryitem;

import org.celllife.idart.udm.common.ValueObject;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h53
 */
@Embeddable
public final class InventoryItemStatus implements ValueObject {

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Enumerated(EnumType.STRING)
    private InventoryItemStatusType statusType;

    public InventoryItemStatus() {
    }

    public InventoryItemStatus(Date dateTime, InventoryItemStatusType statusType) {
        this.dateTime = dateTime;
        this.statusType = statusType;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public InventoryItemStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(InventoryItemStatusType statusType) {
        this.statusType = statusType;
    }
}
