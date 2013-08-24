package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SystemService {

    System save(System system) throws SystemValidationException

    System findBySystemId(SystemId systemId) throws SystemNotFoundException

}
