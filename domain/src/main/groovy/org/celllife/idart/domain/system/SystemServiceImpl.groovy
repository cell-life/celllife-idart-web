package org.celllife.idart.domain.system

import org.celllife.idart.common.SystemIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

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

        systemEventPublisher.systemSaved(system)

        systemRepository.save(system)
    }

    @Override
    System findBySystemIdentifier(SystemIdentifier systemIdentifier) throws SystemNotFoundException {

        def system = systemRepository.findOne(systemIdentifier)

        if (system == null) {
            throw new SystemNotFoundException("Could not find System with System Identifier [${ systemIdentifier}]")
        }

        system
    }
}