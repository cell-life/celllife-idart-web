package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemId


/**
 */
public interface SystemService {

    Boolean exists(SystemId systemId)

    System save(System system)

    System findBySystemId(SystemId systemId)

}
