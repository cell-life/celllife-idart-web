package org.celllife.idart.application.unitofmeasuretype.dto

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureTypeDtoAssembler {

    UnitOfMeasureType toUnitOfMeasureType(UnitOfMeasureTypeDto unitOfMeasureTypeDto) {

        def unitOfMeasureType = new UnitOfMeasureType()
        unitOfMeasureType.with {

        }

        unitOfMeasureType
    }

    UnitOfMeasureTypeDto toUnitOfMeasureTypeDto(UnitOfMeasureType unitOfMeasureType) {

        def unitOfMeasureTypeDto = new UnitOfMeasureTypeDto()
        unitOfMeasureTypeDto.with {

        }

        unitOfMeasureTypeDto
    }
}
