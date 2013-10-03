package org.celllife.idart.application.part.dto

import org.celllife.idart.common.Period
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.PartBillOfMaterialsType

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h51
 */
class PartBillOfMaterialsItemDto implements Serializable {

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
    Set<Identifier> part

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

}