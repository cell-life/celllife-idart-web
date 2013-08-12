package org.celllife.idart.application.indication

import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationValidationException
import org.celllife.idart.domain.indication.IndicationNotFoundException
import org.celllife.idart.common.IndicationCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface IndicationApplicationService {

    Indication save(Indication indication) throws IndicationValidationException

    Indication findByIndicationCode(IndicationCode indicationCode) throws IndicationNotFoundException

}