package org.celllife.idart.domain.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.substitutionreason.SubstitutionReasonEvent.EventType.SAVED
import static org.celllife.idart.domain.substitutionreason.SubstitutionReasonEvent.newSubstitutionReasonEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionReasonServiceImpl implements SubstitutionReasonService {

    @Inject SubstitutionReasonRepository substitutionReasonRepository

    @Inject SubstitutionReasonValidator substitutionReasonValidator

    @Inject SubstitutionReasonEventPublisher substitutionReasonEventPublisher
    
    @Override
    Boolean exists(SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonRepository.exists(substitutionReasonCode)
    }
    
    @Override
    SubstitutionReason save(SubstitutionReason substitutionReason) {

        substitutionReasonValidator.validate(substitutionReason)

        substitutionReasonEventPublisher.publish(newSubstitutionReasonEvent(substitutionReason, SAVED))

        substitutionReasonRepository.save(substitutionReason)
    }
    
    @Override
    SubstitutionReason findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) {

        def substitutionReason = substitutionReasonRepository.findOne(substitutionReasonCode)

        if (substitutionReason == null) {
            throw new SubstitutionReasonNotFoundException("Could not find SubstitutionReason with code [${ substitutionReasonCode}]")
        }

        substitutionReason
    }
}
