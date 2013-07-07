package org.celllife.idart.domain.inventoryitem

import org.celllife.idart.domain.part.Part

import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h47
 */
@Inheritance(strategy = InheritanceType.JOINED)
abstract class InventoryItem {

    /**
     * the physical occurrence of
     */
    @NotNull
    @ManyToOne
    private Part part

    @ElementCollection
    @OrderBy("dateTime")
    private List<InventoryItemStatus> status

    protected InventoryItem() {
    }

    Part getPart() {
        return part
    }

    void setPart(Part part) {
        this.part = part
    }

    List<InventoryItemStatus> getStatus() {
        return status
    }

    void setStatus(List<InventoryItemStatus> status) {
        this.status = status
    }
}
