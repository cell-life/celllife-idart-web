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
@Service class PartServiceImpl implements PartService {

    @Autowired PartRepository partRepository

    @Override
    Part save(Part part) {

        Part existingPart = findByIdentifiers(part.identifiers)
        if (existingPart == null) {
            existingPart = part.class.newInstance()
        }

        existingPart.merge(part)

        partRepository.save(existingPart)
    }


    @Override
    Iterable<Part> findAll() {
        partRepository.findAll()
    }

    @Override
    Part findByIdentifier(String identifier) {
        null
    }

    @Override
    Part findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            Part part = partRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (part != null) {
                return part
            }
        }

        null
    }
}