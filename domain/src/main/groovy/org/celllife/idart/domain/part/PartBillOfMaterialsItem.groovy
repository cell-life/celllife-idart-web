package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode;

import org.celllife.idart.common.PartBillOfMaterialsType
import org.celllife.idart.common.PartId
import org.celllife.idart.common.Period
import org.celllife.idart.common.Quantity

/**
 * Describes the compounds of a drug.
 */
@EqualsAndHashCode
class PartBillOfMaterialsItem implements Serializable {

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

    /*def merge(PartBillOfMaterialsItem that) {

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

        return this.part.equals(that.part) &&
                (this.type == that.type) &&
                (this.quantityUsed == that.quantityUsed)
    }*/

    @Override
    public String toString() {
        return "PartBillOfMaterialsItem [type=" + type + ", valid=" + valid + ", part=" + part + ", quantityUsed="
                + quantityUsed + ", instructions=" + instructions + ", comment=" + comment + "]";
    }
}
