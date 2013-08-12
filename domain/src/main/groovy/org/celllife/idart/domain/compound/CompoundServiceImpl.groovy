package org.celllife.idart.domain.compound

import org.celllife.idart.common.PartIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.compound.CompoundEvent.EventType.SAVED
import static org.celllife.idart.domain.compound.CompoundEvent.newCompoundEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class CompoundServiceImpl implements CompoundService {

    @Autowired CompoundRepository compoundRepository

    @Autowired CompoundValidator compoundValidator

    @Autowired CompoundEventPublisher compoundEventPublisher

    @Override
    Compound save(Compound compound) throws CompoundValidationException {

        compoundValidator.validate(compound)

        compoundEventPublisher.publish(newCompoundEvent(compound, SAVED))

        compoundRepository.save(compound)
    }

    @Override
    Compound findByPartIdentifier(PartIdentifier partIdentifier) throws CompoundNotFoundException {

        def compound = compoundRepository.findOne(partIdentifier)

        if (compound == null) {
            throw new CompoundNotFoundException("Could not find Compound with Part Identifier [${ partIdentifier}]")
        }

        compound
    }
}