package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Quantity

import javax.validation.constraints.NotNull

import static org.celllife.idart.framework.aspectj.InjectIdentified.inject

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */
class PartBillOfMaterialsItem {

    /**
     * Persistence Key
     */
    Long pk

    PartBillOfMaterialsType type

    @NotNull
    Date fromDate

    Date thruDate

    @NotNull
    Part part

    Quantity quantityUsed

    String instructions

    String comment

    void setPart(Part part) {
        this.part = inject(part)
    }
}
