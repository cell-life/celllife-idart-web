package org.celllife.idart.domain.substitution

import org.celllife.idart.common.SubstitutionCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.substitution.SubstitutionEvent.EventType.SAVED
import static org.celllife.idart.domain.substitution.SubstitutionEvent.newSubstitutionEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionServiceImpl implements SubstitutionService {

    @Inject SubstitutionRepository substitutionRepository

    @Inject SubstitutionValidator substitutionValidator

    @Inject SubstitutionEventPublisher substitutionEventPublisher

    @Override
    Boolean exists(SubstitutionCode substitutionCode) {
        substitutionRepository.exists(substitutionCode)
    }

    @Override
    Substitution save(Substitution substitution) {

        def existingSubstitution = substitutionRepository.findOne(substitution.id)

        if (existingSubstitution == null) {
            existingSubstitution = substitution
        } else {
            existingSubstitution.merge(substitution)
        }

        substitutionValidator.validate(existingSubstitution)

        substitutionEventPublisher.publish(newSubstitutionEvent(existingSubstitution, SAVED))

        substitutionRepository.save(existingSubstitution)
    }

    @Override
    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode) {

        def substitution = substitutionRepository.findOne(substitutionCode)

        if (substitution == null) {
            throw new SubstitutionNotFoundException("Could not find Substitution with code [${ substitutionCode}]")
        }

        substitution
    }
}
