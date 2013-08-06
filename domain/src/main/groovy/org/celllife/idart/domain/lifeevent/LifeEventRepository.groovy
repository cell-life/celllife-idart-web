package org.celllife.idart.domain.lifeevent

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface LifeEventRepository {

    LifeEvent save(LifeEvent lifeEvent)

    LifeEvent findOne(LifeEventCode code)

}
