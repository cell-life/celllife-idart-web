package org.celllife.idart.domain.part

import static org.celllife.idart.common.PartBillOfMaterialsType.ENGINEERING

import org.celllife.idart.common.PartId
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.UnitOfMeasureCode

/**
 * Drugs are one Part of the Medication given to a Patient. It is a medicine that can be given in many forms 
 * (e.g. Syrup or Capsules).
 */
class Drug extends Part {

    /**
     * Made up of
     */
    Set<PartBillOfMaterialsItem> billOfMaterials = []

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
        
        that.billOfMaterials?.each { billOfMaterial -> this.billOfMaterials << billOfMaterial }
    }

    @Override
    public String toString() {
        def str = "Drug [id=" + id + ", label=" + label + ", quantity=" + quantity + ", form=" + form + ", billOfMaterials=["
        for (b in this.billOfMaterials) {
            str = str + " " + b
        }
        str = str + "], classifications=["
        for (c in this.classifications) {
            str = str + " " + c
        }
        str = str + "] ]";
        str
    }
}