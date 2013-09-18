package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemId


/**
 */
public interface SystemRepository {

    boolean exists(SystemId systemId)

    System save(System system)

    System findOne(SystemId systemId)

}
