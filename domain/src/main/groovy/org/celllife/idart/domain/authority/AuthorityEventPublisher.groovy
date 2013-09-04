package org.celllife.idart.domain.authority

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface AuthorityEventPublisher {

    void publish(AuthorityEvent authorityEvent)

}
