package org.celllife.idart.security.unitofmeasure

import org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDto
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.unitofmeasure.UnitOfMeasureApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureSecurityAdapter {

    @Inject UnitOfMeasureApplicationService unitOfMeasureApplicationService

    UnitOfMeasureCode save(Principal principal, UnitOfMeasureDto unitOfMeasureDto) {
        unitOfMeasureApplicationService.save(unitOfMeasureDto)
    }

    UnitOfMeasureDto findByUnitOfMeasureCode(Principal principal, UnitOfMeasureCode unitOfMeasureCode) {
        unitOfMeasureApplicationService.findByUnitOfMeasureCode(unitOfMeasureCode)
    }

    UnitOfMeasureDto findByIdentifier(Principal principal, Identifier identifier) {
        unitOfMeasureApplicationService.findByIdentifier(identifier)
    }

}
