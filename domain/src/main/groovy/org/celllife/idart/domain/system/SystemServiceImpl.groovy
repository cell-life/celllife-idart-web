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
    Boolean exists(SystemId systemId) {
        systemRepository.exists(systemId)
    }

    @Override
    System save(System system) {

        def existingSystem = systemRepository.findOne(system.id)

        if (existingSystem == null) {
            existingSystem = system
        } else {
            existingSystem.merge(system)
        }

        systemValidator.validate(existingSystem)

        systemEventPublisher.publish(newSystemEvent(existingSystem, SAVED))

        systemRepository.save(existingSystem)
    }

    @Override
    System findBySystemId(SystemId systemId) {

        def system = systemRepository.findOne(systemId)

        if (system == null) {
            throw new SystemNotFoundException("Could not find System with id [${ systemId}]")
        }

        system
    }
}
