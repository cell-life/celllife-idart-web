package org.celllife.idart.application.dispensation

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationValidationException
import org.celllife.idart.domain.dispensation.DispensationNotFoundException
import org.celllife.idart.common.DispensationIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DispensationApplicationService {

    Dispensation save(Dispensation dispensation) throws DispensationValidationException

    Dispensation findByDispensationIdentifier(DispensationIdentifier dispensationIdentifier) throws DispensationNotFoundException

}