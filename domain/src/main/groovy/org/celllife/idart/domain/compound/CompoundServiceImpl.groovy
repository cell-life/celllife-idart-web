package org.celllife.idart.domain.compound

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CompoundServiceImpl implements CompoundService {

    @Autowired CompoundRepository compoundRepository

    @Autowired CompoundSequence compoundSequence

    @Autowired CompoundValidator compoundValidator

    @Override
    Compound save(Compound newCompound) {

        compoundValidator.validate(newCompound)

        def existingCompound = findByIdentifiers(newCompound.identifiers)

        if (requiresIdartIdentifier(newCompound, existingCompound)) {
            newCompound.addIdentifier(Compound.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingCompound == null) {
            existingCompound = new Compound()
        }

        existingCompound.merge(newCompound)

        compoundRepository.save(existingCompound)
    }

    @Override
    Compound findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingCompound = compoundRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingCompound != null) {
                return existingCompound
            }
        }

        null
    }

    @Override
    Compound findByIdentifier(String identifier) {
        compoundRepository.findOneByIdentifier(Compound.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Compound> findAll() {
        compoundRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", compoundSequence.nextValue())
    }

    static requiresIdartIdentifier(Compound... compounds) {

        for (Compound compound in compounds) {
            if (compound?.hasIdentifierForSystem(Compound.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
