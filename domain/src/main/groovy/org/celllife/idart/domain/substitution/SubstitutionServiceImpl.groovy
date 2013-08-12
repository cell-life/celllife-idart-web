package org.celllife.idart.domain.substitution

import org.celllife.idart.common.SubstitutionCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubstitutionServiceImpl implements SubstitutionService {

    @Autowired SubstitutionRepository substitutionRepository

    @Autowired SubstitutionValidator substitutionValidator

    @Autowired SubstitutionEventPublisher substitutionEventPublisher

    @Override
    Substitution save(Substitution substitution) throws SubstitutionValidationException {

        substitutionValidator.validate(substitution)

        substitutionEventPublisher.substitutionSaved(substitution)

        substitutionRepository.save(substitution)
    }

    @Override
    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode) throws SubstitutionNotFoundException {

        def substitution = substitutionRepository.findOne(substitutionCode)

        if (substitution == null) {
            throw new SubstitutionNotFoundException("Could not find Substitution with Substitution Code [${ substitutionCode}]")
        }

        substitution
    }
}