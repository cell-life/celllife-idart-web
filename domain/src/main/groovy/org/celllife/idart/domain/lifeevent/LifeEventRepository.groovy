package org.celllife.idart.domain.lifeevent

import org.celllife.idart.common.LifeEventCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LifeEventRepository {

    boolean exists(LifeEventCode lifeEventCode)

    LifeEvent save(LifeEvent lifeEvent)

    LifeEvent findOne(LifeEventCode lifeEventCode)

}
