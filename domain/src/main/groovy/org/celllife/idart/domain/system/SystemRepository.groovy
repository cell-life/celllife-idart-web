package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SystemRepository {

    System save(System system)

    System findOne(SystemIdentifier systemIdentifier)

}
