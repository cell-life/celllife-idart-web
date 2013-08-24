package org.celllife.idart.domain.prescription

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescriptionEventPublisher {

    void publish(PrescriptionEvent prescriptionEvent)

}
