package org.celllife.idart.domain.drug

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DrugEventPublisher {

    void publish(DrugEvent drugEvent)

}
