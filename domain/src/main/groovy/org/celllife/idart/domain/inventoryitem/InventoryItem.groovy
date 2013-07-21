package org.celllife.idart.domain.inventoryitem

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.part.Part

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h47
 */
abstract class InventoryItem implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    /**
     * the physical occurrence of
     */
    @NotNull
    Part part

    List<InventoryItemStatus> status = []

}
