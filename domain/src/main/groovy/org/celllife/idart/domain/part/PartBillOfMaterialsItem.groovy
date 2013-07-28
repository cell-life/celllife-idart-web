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

    Date fromDate

    Date thruDate

    @NotNull
    Part part

    Quantity quantityUsed

    String instructions

    String comment

    def merge(PartBillOfMaterialsItem that) {
        this.fromDate = that.fromDate
        this.thruDate = that.thruDate
        this.part = that.part
        this.quantityUsed = that.quantityUsed
        this.instructions = that.instructions
        this.comment = that.comment
    }

    def matches(PartBillOfMaterialsItem that) {

        if (that == null) {
            return false
        }

        if (this.part == null && that.part == null) {
            return true
        }

        if (this.part == null || that.part == null) {
            return false
        }

        return this.part.matches(that.part)
    }
}
