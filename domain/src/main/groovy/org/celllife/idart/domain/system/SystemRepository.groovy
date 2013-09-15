package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SystemRepository {

    boolean exists(SystemId systemId)

    System save(System system)

    System findOne(SystemId systemId)

}
