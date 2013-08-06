package org.celllife.idart.domain.system

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
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
    System findByIdentifier(SystemIdentifier identifier) throws SystemNotFoundException {

        def system = systemRepository.findOne(identifier)

        if (system == null) {
            throw new SystemNotFoundException("Could not find System with Identifier [${ identifier}]")
        }

        system
    }
}