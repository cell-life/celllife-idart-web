package org.celllife.idart.udm.inventoryitem;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h48
 */
@Entity
public final class SerialisedInventoryItem extends InventoryItem {

    @NotNull
    private String serialNumber;

    public SerialisedInventoryItem() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
