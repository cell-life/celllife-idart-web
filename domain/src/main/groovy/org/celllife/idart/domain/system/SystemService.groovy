package org.celllife.idart.domain.system

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SystemService {

    System save(System system) throws SystemValidationException

    System findByIdentifier(SystemIdentifier identifier) throws SystemNotFoundException

}