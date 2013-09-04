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
    Substitution save(Substitution substitution) {

        substitutionValidator.validate(substitution)

        substitutionEventPublisher.publish(newSubstitutionEvent(substitution, SAVED))

        substitutionRepository.save(substitution)
    }

    @Override
    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode) {

        def substitution = substitutionRepository.findOne(substitutionCode)

        if (substitution == null) {
            throw new SubstitutionNotFoundException("Could not find Substitution with Substitution Code [${ substitutionCode}]")
        }

        substitution
    }
}
