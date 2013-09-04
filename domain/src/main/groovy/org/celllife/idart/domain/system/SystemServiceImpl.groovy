package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.system.SystemEvent.EventType.SAVED
import static org.celllife.idart.domain.system.SystemEvent.newSystemEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SystemServiceImpl implements SystemService {

    @Inject SystemRepository systemRepository

    @Inject SystemValidator systemValidator

    @Inject SystemEventPublisher systemEventPublisher

    @Override
    System save(System system) {

        systemValidator.validate(system)

        systemEventPublisher.publish(newSystemEvent(system, SAVED))

        systemRepository.save(system)
    }

    @Override
    System findBySystemId(SystemId systemId) {

        def system = systemRepository.findOne(systemId)

        if (system == null) {
            throw new SystemNotFoundException("Could not find System with System Id [${ systemId}]")
        }

        system
    }
}
