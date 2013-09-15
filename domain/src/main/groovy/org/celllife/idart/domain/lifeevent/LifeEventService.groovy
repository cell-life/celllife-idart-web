package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.LifeEventCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LifeEventService {

    Boolean exists(LifeEventCode lifeEventCode)

    LifeEvent save(LifeEvent lifeEvent)

    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode)

}
