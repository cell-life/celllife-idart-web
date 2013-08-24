package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensationService {

    Dispensation save(Dispensation dispensation) throws DispensationValidationException

    Dispensation findByDispensationId(DispensationId dispensationId) throws DispensationNotFoundException

}
