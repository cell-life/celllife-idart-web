package org.celllife.idart.domain.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubstitutionReasonServiceImpl implements SubstitutionReasonService {

    @Autowired SubstitutionReasonRepository substitutionReasonRepository

    @Autowired SubstitutionReasonValidator substitutionReasonValidator

    @Autowired SubstitutionReasonEventPublisher substitutionReasonEventPublisher

    @Override
    SubstitutionReason save(SubstitutionReason substitutionReason) throws SubstitutionReasonValidationException {

        substitutionReasonValidator.validate(substitutionReason)

        substitutionReasonEventPublisher.substitutionReasonSaved(substitutionReason)

        substitutionReasonRepository.save(substitutionReason)
    }

    @Override
    SubstitutionReason findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) throws SubstitutionReasonNotFoundException {

        def substitutionReason = substitutionReasonRepository.findOne(substitutionReasonCode)

        if (substitutionReason == null) {
            throw new SubstitutionReasonNotFoundException("Could not find SubstitutionReason with Substitution Reason Code [${ substitutionReasonCode}]")
        }

        substitutionReason
    }
}