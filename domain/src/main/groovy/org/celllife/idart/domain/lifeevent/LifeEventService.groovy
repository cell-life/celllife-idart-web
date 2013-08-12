package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.LifeEventCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LifeEventService {

    LifeEvent save(LifeEvent lifeEvent) throws LifeEventValidationException

    LifeEvent findByLifeEventCode(LifeEventCode lifeEventCode) throws LifeEventNotFoundException

}