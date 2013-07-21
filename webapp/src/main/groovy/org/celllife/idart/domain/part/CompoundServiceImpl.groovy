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
@Service class CompoundServiceImpl implements CompoundService {

    @Autowired CompoundRepository compoundRepository

    @Override
    Compound save(Compound compound) {

        Compound existingCompound = findByIdentifiers(compound.identifiers)
        if (existingCompound == null) {
            existingCompound = compound.class.newInstance()
        }

        existingCompound.merge(compound)

        compoundRepository.save(existingCompound)
    }


    @Override
    Iterable<Compound> findAll() {
        compoundRepository.findAll()
    }

    @Override
    Compound findByIdentifier(String identifier) {
        null
    }

    @Override
    Compound findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            Compound compound = compoundRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (compound != null) {
                return compound
            }
        }

        null
    }
}