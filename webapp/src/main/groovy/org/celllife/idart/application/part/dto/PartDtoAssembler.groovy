package org.celllife.idart.application.part.dto

import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.domain.part.Compound
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartBillOfMaterialsItem

import javax.inject.Inject
import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
@Named class PartDtoAssembler {

    @Inject PartApplicationService partApplicationService

    Part toPart(PartDto partDto) {
        switch (partDto.class) {
            case DrugDto:
                return toDrug(partDto as DrugDto)
            case CompoundDto:
                return toCompound(partDto as CompoundDto)
            default:
                throw new UnsupportedPartDtoType(partDto.class)
        }
    }

    Drug toDrug(DrugDto drugDto) {

        def drug = new Drug()
        drug.with {
            label = drugDto.label
            form = drugDto.form
            quantity = drugDto.quantity
            classifications = drugDto.classifications
            billOfMaterials = drugDto.billOfMaterials.collect { billOfMaterial -> toPartBillOfMaterialsItem(billOfMaterial) }
        }

        drug
    }

    Compound toCompound(CompoundDto compoundDto) {

        def compound = new Compound()
        compound.with {
            label = compoundDto.label
            form = compoundDto.form
            quantity = compoundDto.quantity
            classifications = compoundDto.classifications
        }

        compound
    }

    PartBillOfMaterialsItem toPartBillOfMaterialsItem(PartBillOfMaterialsItemDto partBillOfMaterialsItemDto) {

        def partBillOfMaterialsItem = new PartBillOfMaterialsItem()
        partBillOfMaterialsItem.with {
            type = partBillOfMaterialsItemDto.type
            part = partApplicationService.findByIdentifiers(partBillOfMaterialsItemDto.part)
            valid = partBillOfMaterialsItemDto.valid
            quantityUsed = partBillOfMaterialsItemDto.quantityUsed
            instructions = partBillOfMaterialsItemDto.instructions
            comment = partBillOfMaterialsItemDto.comment
        }

        partBillOfMaterialsItem
    }

    PartDto toPartDto(Part part) {
        switch (part.class) {
            case Drug:
                return toDrugDto(part as Drug)
            case Compound:
                return toCompoundDto(part as Compound)
            default:
                throw new UnsupportedPartType(part.class)
        }
    }

    DrugDto toDrugDto(Drug drug) {

        def drugDto = new DrugDto()
        drugDto.with {
            label = drug.label
            form = drug.form
            quantity = drug.quantity
            classifications = drug.classifications
            billOfMaterials = drug.billOfMaterials.collect { billOfMaterial -> toPartBillOfMaterialsItemDto(billOfMaterial) }
        }

        drugDto
    }

    CompoundDto toCompoundDto(Compound compound) {

        def compoundDto = new CompoundDto()
        compoundDto.with {
            label = compound.label
            form = compound.form
            quantity = compound.quantity
            classifications = compound.classifications
        }

        compoundDto
    }

    PartBillOfMaterialsItemDto toPartBillOfMaterialsItemDto(PartBillOfMaterialsItem partBillOfMaterialsItem) {

        def partBillOfMaterialsItemDto = new PartBillOfMaterialsItemDto()
        partBillOfMaterialsItemDto.with {
            type = partBillOfMaterialsItem.type
            part = partApplicationService.findByPartId(partBillOfMaterialsItem.part).identifiers
            valid = partBillOfMaterialsItem.valid
            quantityUsed = partBillOfMaterialsItem.quantityUsed
            instructions = partBillOfMaterialsItem.instructions
            comment = partBillOfMaterialsItem.comment
        }

        partBillOfMaterialsItemDto
    }
}
