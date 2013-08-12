package org.celllife.idart.domain.dispensation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DispensationEventPublisher {

    void publish(DispensationEvent dispensationEvent)

}