package org.celllife.idart.domain.substitutionreason

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubstitutionReasonServiceImpl implements SubstitutionReasonService {

    @Autowired SubstitutionReasonRepository substitutionReasonRepository

    @Autowired SubstitutionReasonValidator substitutionReasonValidator

    @Override
    SubstitutionReason save(SubstitutionReason substitutionReason) throws SubstitutionReasonValidationException {

        substitutionReasonValidator.validate(substitutionReason)

        substitutionReasonRepository.save(substitutionReason)
    }

    @Override
    SubstitutionReason findByCode(SubstitutionReasonCode code) throws SubstitutionReasonNotFoundException {

        def substitutionReason = substitutionReasonRepository.findOne(code)

        if (substitutionReason == null) {
            throw new SubstitutionReasonNotFoundException("Could not find SubstitutionReason with Code [${ code}]")
        }

        substitutionReason
    }
}