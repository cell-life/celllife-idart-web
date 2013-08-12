package org.celllife.idart.domain.patient

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PatientEventPublisher {

    void publish(PatientEvent patientEvent)

}