package org.celllife.idart.application.part.dto

import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.Quantity;

/**
 * A Data Transfer Object (DTO) for the Part domain entity
 */
class DrugDto extends PartDto {

    /**
     * Made up of
     */
    Set<PartBillOfMaterialsItemDto> billOfMaterials = [] as Set<PartBillOfMaterialsItemDto>

}
