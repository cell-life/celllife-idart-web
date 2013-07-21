package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubassemblyServiceImpl implements SubassemblyService {

    @Autowired SubassemblyRepository subassemblyRepository

    @Override
    Subassembly save(Subassembly subassembly) {

        Subassembly existingSubassembly = findByIdentifiers(subassembly.identifiers)
        if (existingSubassembly == null) {
            existingSubassembly = subassembly.class.newInstance()
        }

        existingSubassembly.merge(subassembly)

        subassemblyRepository.save(existingSubassembly)
    }


    @Override
    Iterable<Subassembly> findAll() {
        subassemblyRepository.findAll()
    }

    @Override
    Subassembly findByIdentifier(String identifier) {
        null
    }

    @Override
    Subassembly findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            Subassembly subassembly = subassemblyRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (subassembly != null) {
                return subassembly
            }
        }

        null
    }
}