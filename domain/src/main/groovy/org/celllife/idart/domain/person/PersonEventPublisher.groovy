package org.celllife.idart.domain.person

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PersonEventPublisher {

    void publish(PersonEvent personEvent)

}