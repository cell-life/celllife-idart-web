package org.celllife.idart.domain.indication

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface IndicationRepository {

    Indication save(Indication indication)

    Indication findOne(IndicationCode code)

}
