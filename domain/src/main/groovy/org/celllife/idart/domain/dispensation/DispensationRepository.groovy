package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensationRepository {

    Dispensation save(Dispensation dispensation)

    Dispensation findOne(DispensationId dispensationId)

}
