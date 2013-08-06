package org.celllife.idart.domain.lifeevent

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LifeEventService {

    LifeEvent save(LifeEvent lifeEvent) throws LifeEventValidationException

    LifeEvent findByCode(LifeEventCode code) throws LifeEventNotFoundException

}