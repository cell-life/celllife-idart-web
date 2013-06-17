package org.celllife.idart.udm.inventoryitem;

import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.udm.part.Part;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h47
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InventoryItem extends BaseEntity {

    /**
     * the physical occurrence of
     */
    @NotNull
    @ManyToOne
    private Part part;

    @ElementCollection
    @OrderBy("dateTime")
    private List<InventoryItemStatus> status;

    protected InventoryItem() {
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public List<InventoryItemStatus> getStatus() {
        return status;
    }

    public void setStatus(List<InventoryItemStatus> status) {
        this.status = status;
    }
}
