package org.celllife.idart.domain.drug

import org.celllife.idart.common.Quantity
import org.celllife.idart.domain.part.EngineeringPartBillOfMaterialsItem
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartBillOfMaterialsItem
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h31
 */
class Drug extends Part {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/drugs"

    /**
     * Made up of
     */
    Set<PartBillOfMaterialsItem> billOfMaterials = [] as Set<PartBillOfMaterialsItem>

    def addEngineeringPart(Part engineeringPart, Double quantity, UnitOfMeasure unitOfMeasure) {
        this.billOfMaterials << new EngineeringPartBillOfMaterialsItem(
                part: engineeringPart,
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
