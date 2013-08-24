package org.celllife.idart.domain.indication

import org.celllife.idart.common.IndicationCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface IndicationService {

    Indication save(Indication indication) throws IndicationValidationException

    Indication findByIndicationCode(IndicationCode indicationCode) throws IndicationNotFoundException

}
