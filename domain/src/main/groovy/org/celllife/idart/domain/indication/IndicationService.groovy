package org.celllife.idart.domain.indication

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface IndicationService {

    Indication save(Indication indication) throws IndicationValidationException

    Indication findByCode(IndicationCode code) throws IndicationNotFoundException

}