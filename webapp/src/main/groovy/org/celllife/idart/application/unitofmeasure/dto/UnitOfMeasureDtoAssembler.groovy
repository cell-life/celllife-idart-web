package org.celllife.idart.application.unitofmeasure.dto

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureDtoAssembler {

    UnitOfMeasure toUnitOfMeasure(UnitOfMeasureDto unitOfMeasureDto) {

        def unitOfMeasure = new UnitOfMeasure()
        unitOfMeasure.with {

        }

        unitOfMeasure
    }

    UnitOfMeasureDto toUnitOfMeasureDto(UnitOfMeasure unitOfMeasure) {

        def unitOfMeasureDto = new UnitOfMeasureDto()
        unitOfMeasureDto.with {

        }

        unitOfMeasureDto
    }
}
