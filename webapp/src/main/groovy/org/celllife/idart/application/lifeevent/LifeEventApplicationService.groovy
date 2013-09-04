package org.celllife.idart.application.lifeevent

import org.celllife.idart.common.LifeEventCode
import org.celllife.idart.domain.lifeevent.LifeEvent

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface LifeEventApplicationService {

    LifeEvent save(LifeEvent lifeEvent)

    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode)

}
