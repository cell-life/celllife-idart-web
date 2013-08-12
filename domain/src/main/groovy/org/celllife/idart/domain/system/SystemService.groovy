package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SystemService {

    System save(System system) throws SystemValidationException

    System findBySystemIdentifier(SystemIdentifier systemIdentifier) throws SystemNotFoundException

}