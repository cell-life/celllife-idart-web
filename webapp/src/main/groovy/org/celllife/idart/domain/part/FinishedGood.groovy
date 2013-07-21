package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Quantity
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h18
 */
abstract class FinishedGood extends Part {

    /**
     * Made up of
     */
    Set<PartBillOfMaterialsItem> billOfMaterials = [] as Set<PartBillOfMaterialsItem>

    def addEngineeringPart(Date fromDate, Part engineeringPart, Double quantity, UnitOfMeasure unitOfMeasure) {
        this.billOfMaterials << new EngineeringPartBillOfMaterialsItem(
                fromDate: fromDate,
                part: engineeringPart,
                quantityUsed: new Quantity(
                        value: quantity,
                        unitOfMeasure: unitOfMeasure
                )
        )
    }

    def merge(FinishedGood that) {

        if (that == null) {
            return
        }

        super.merge(that)
        that.billOfMaterials?.each { billOfMaterial -> this.billOfMaterials << billOfMaterial }
    }
}
