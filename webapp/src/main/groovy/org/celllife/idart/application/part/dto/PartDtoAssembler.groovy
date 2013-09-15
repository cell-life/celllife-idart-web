package org.celllife.idart.application.part.dto

import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartBillOfMaterialsItem

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
class PartDtoAssembler {

    static Part toPart(PartDto partDto) {
        switch (partDto.class) {
            case DrugDto:
                return toDrug(partDto as DrugDto)
            case CompoundDto:
                return toCompound(partDto as CompoundDto)
            default:
                throw new UnsupportedPartDtoType(partDto.class)
        }
    }

    static Drug toDrug(DrugDto drugDto) {

        def drug = new Drug()
        drug.with {
            label = drugDto.label
            form = drugDto.form
            unitOfMeasure = drugDto.unitOfMeasure
            classifications = drugDto.classifications
            billOfMaterials = drugDto.billOfMaterials.collect { billOfMaterial -> toPartBillOfMaterialsItem(billOfMaterial) }
        }

        drug
    }

    static Compound toCompound(CompoundDto compoundDto) {

        def compound = new Compound()
        compound.with {
            label = compoundDto.label
            form = compoundDto.form
            unitOfMeasure = compoundDto.unitOfMeasure
            classifications = compoundDto.classifications
        }

        compound
    }

    static PartBillOfMaterialsItem toPartBillOfMaterialsItem(PartBillOfMaterialsItemDto partBillOfMaterialsItemDto) {

        def partBillOfMaterialsItem = new PartBillOfMaterialsItem()
        partBillOfMaterialsItem.with {
            type = partBillOfMaterialsItemDto.type
            valid = partBillOfMaterialsItemDto.valid
            quantityUsed = partBillOfMaterialsItemDto.quantityUsed
            instructions = partBillOfMaterialsItemDto.instructions
            comment = partBillOfMaterialsItemDto.comment
        }

        partBillOfMaterialsItem
    }

    static PartDto toPartDto(Part part) {
        switch (part.class) {
            case Drug:
                return toDrugDto(part as Drug)
            case CompoundDto:
                return toCompoundDto(part as Compound)
            default:
                throw new UnsupportedPartType(part.class)
        }
    }

    static DrugDto toDrugDto(Drug drug) {

        def drugDto = new DrugDto()
        drugDto.with {
            label = drug.label
            form = drug.form
            unitOfMeasure = drug.unitOfMeasure
            classifications = drug.classifications
            billOfMaterials = drug.billOfMaterials.collect { billOfMaterial -> toPartBillOfMaterialsItemDto(billOfMaterial) }
        }

        drugDto
    }

    static CompoundDto toCompoundDto(Compound compound) {

        def compoundDto = new CompoundDto()
        compoundDto.with {
            label = compound.label
            form = compound.form
            unitOfMeasure = compound.unitOfMeasure
            classifications = compound.classifications
        }

        compoundDto
    }

    static PartBillOfMaterialsItemDto toPartBillOfMaterialsItemDto(PartBillOfMaterialsItem partBillOfMaterialsItem) {

        def partBillOfMaterialsItemDto = new PartBillOfMaterialsItemDto()
        partBillOfMaterialsItemDto.with {
            type = partBillOfMaterialsItem.type
            valid = partBillOfMaterialsItem.valid
            quantityUsed = partBillOfMaterialsItem.quantityUsed
            instructions = partBillOfMaterialsItem.instructions
            comment = partBillOfMaterialsItem.comment
        }

        partBillOfMaterialsItemDto
    }
}
