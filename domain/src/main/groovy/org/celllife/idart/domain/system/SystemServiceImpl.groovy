package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.system.SystemEvent.EventType.SAVED
import static org.celllife.idart.domain.system.SystemEvent.newSystemEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SystemServiceImpl implements SystemService {

    @Autowired SystemRepository systemRepository

    @Autowired SystemValidator systemValidator

    @Autowired SystemEventPublisher systemEventPublisher

    @Override
    System save(System system) throws SystemValidationException {

        systemValidator.validate(system)

        systemEventPublisher.publish(newSystemEvent(system, SAVED))

        systemRepository.save(system)
    }

    @Override
    System findBySystemId(SystemId systemId) throws SystemNotFoundException {

        def system = systemRepository.findOne(systemId)

        if (system == null) {
            throw new SystemNotFoundException("Could not find System with System Id [${ systemId}]")
        }

        system
    }
}
