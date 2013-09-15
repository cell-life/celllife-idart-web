package org.celllife.idart.domain.indication

import org.celllife.idart.common.IndicationCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface IndicationRepository {

    boolean exists(IndicationCode indicationCode)

    Indication save(Indication indication)

    Indication findOne(IndicationCode indicationCode)

}
