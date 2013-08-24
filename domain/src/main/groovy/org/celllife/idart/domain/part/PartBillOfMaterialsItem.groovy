package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId
import org.celllife.idart.common.Period
import org.celllife.idart.common.Quantity

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */
class PartBillOfMaterialsItem {

    /**
     * Of type
     */
    PartBillOfMaterialsType type

    /**
     * Valid during
     */
    Period valid

    /**
     *  Made up of
     */
    PartId part

    /**
     * Quantity Used
     */
    Quantity quantityUsed

    /**
     * Instructions
     */
    String instructions

    /**
     * Comment
     */
    String comment

    def merge(PartBillOfMaterialsItem that) {

        if (that == null) {
            return
        }

        this.type = that.type
        this.valid = that.valid
        this.part = that.part
        this.quantityUsed = that.quantityUsed
        this.instructions = that.instructions
        this.comment = that.comment
    }

    def matches(PartBillOfMaterialsItem that) {

        if (that == null) {
            return false
        }

        return this.part.matches(that.part) &&
                (this.type == that.type) &&
                (this.quantityUsed == that.quantityUsed)
    }
}
