package org.celllife.idart.security.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
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

    UnitOfMeasure save(Principal principal, UnitOfMeasure unitOfMeasure) {
        unitOfMeasureApplicationService.save(unitOfMeasure)
    }

    UnitOfMeasure findByUnitOfMeasureCode(Principal principal, UnitOfMeasureCode unitOfMeasureCode) {
        unitOfMeasureApplicationService.findByUnitOfMeasureCode(unitOfMeasureCode)
    }

}
