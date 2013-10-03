package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.UnitOfMeasureCode

import static org.celllife.idart.common.PartBillOfMaterialsType.ENGINEERING

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h31
 */
class Drug extends Part {

    /**
     * Made up of
     */
    Set<PartBillOfMaterialsItem> billOfMaterials = [] as Set<PartBillOfMaterialsItem>

    def addEngineeringPart(PartId part, Double quantity, UnitOfMeasureCode unitOfMeasure) {
        this.billOfMaterials << new PartBillOfMaterialsItem(
                type: ENGINEERING,
                part: part,
                quantityUsed: new Quantity(
                        value: quantity,
                        unitOfMeasure: unitOfMeasure
                )
        )
    }

    def merge(Drug that) {

        if (that == null) {
            return
        }

        super.merge(that)

        if (that.billOfMaterials != null) {
            for (thatBillOfMaterial in that.billOfMaterials) {
                addNewOrMergeExisting(thatBillOfMaterial)
            }
        }
    }

    def addNewOrMergeExisting(PartBillOfMaterialsItem thatBillOfMaterial) {

        for (thisBillOfMaterial in this.billOfMaterials) {
            if (thisBillOfMaterial.matches(thatBillOfMaterial)) {
                // Existing bill of materials... merge
                thisBillOfMaterial.merge(thatBillOfMaterial)
                return
            }
        }

        // Not found in this.billOfMaterials
        this.billOfMaterials << thatBillOfMaterial
    }
}
