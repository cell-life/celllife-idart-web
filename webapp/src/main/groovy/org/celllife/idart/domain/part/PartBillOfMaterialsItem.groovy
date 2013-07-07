package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Quantity

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */
abstract class PartBillOfMaterialsItem {

    /**
     * Persistence Key
     */
    Long pk

    @NotNull
    Date fromDate

    Date thruDate

    @NotNull
    Part part

    Quantity quantityUsed

    String instructions

    String comment

}
