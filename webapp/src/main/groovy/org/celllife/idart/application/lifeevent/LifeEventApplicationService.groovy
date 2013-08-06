package org.celllife.idart.application.lifeevent

import org.celllife.idart.domain.lifeevent.LifeEvent
import org.celllife.idart.domain.lifeevent.LifeEventValidationException
import org.celllife.idart.domain.lifeevent.LifeEventNotFoundException
import org.celllife.idart.domain.lifeevent.LifeEventCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface LifeEventApplicationService {

    LifeEvent save(LifeEvent lifeEvent) throws LifeEventValidationException

    LifeEvent findByCode(LifeEventCode code) throws LifeEventNotFoundException

}