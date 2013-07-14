package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Quantity
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

import static org.celllife.idart.domain.part.PartBillOfMaterialsType.ENGINEERING

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h19
 */
class Subassembly extends Part {

    /**
     * Made up of
     */
    Set<PartBillOfMaterialsItem> billOfMaterials = [] as Set<PartBillOfMaterialsItem>

    def addEngineeringPart(Date fromDate, Part engineeringPart, Double quantity, UnitOfMeasure unitOfMeasure) {
        this.billOfMaterials << new PartBillOfMaterialsItem(
                type: ENGINEERING,
                fromDate: fromDate,
                part: engineeringPart,
                quantityUsed: new Quantity(
                        value: quantity,
                        unitOfMeasure: unitOfMeasure
                )
        )
    }
}
