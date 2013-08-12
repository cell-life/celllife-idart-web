package org.celllife.idart.application.system

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemValidationException
import org.celllife.idart.domain.system.SystemNotFoundException
import org.celllife.idart.common.SystemIdentifier
import org.celllife.idart.domain.system.SystemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SystemApplicationServiceImpl implements SystemApplicationService {

    @Autowired SystemService systemService

    System save(System system) throws SystemValidationException {
        systemService.save(system)
    }

    System findBySystemIdentifier(SystemIdentifier systemIdentifier) throws SystemNotFoundException{
        systemService.findBySystemIdentifier(systemIdentifier)
    }

}