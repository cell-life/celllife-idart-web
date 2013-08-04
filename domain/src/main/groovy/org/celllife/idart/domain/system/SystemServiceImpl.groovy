package org.celllife.idart.domain.system

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SystemServiceImpl implements SystemService {

    @Autowired SystemRepository systemRepository

    @Override
    Iterable<System> save(Iterable<System> systems) {
        systemRepository.save(systems)
    }

    @Override
    System save(System system) {
        systemRepository.save(system)
    }

    @Override
    Iterable<System> findAll() {
        systemRepository.findAll()
    }

    @Override
    System findByIdentifier(String identifier) {
        systemRepository.findOneByIdentifier(identifier)
    }
}