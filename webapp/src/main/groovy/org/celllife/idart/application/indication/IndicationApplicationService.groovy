package org.celllife.idart.application.indication

import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.indication.Indication

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface IndicationApplicationService {

    Indication save(Indication indication)

    Indication findByIndicationCode(IndicationCode indicationCode)

}
