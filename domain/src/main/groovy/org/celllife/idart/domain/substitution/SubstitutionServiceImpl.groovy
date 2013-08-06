package org.celllife.idart.domain.substitution

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubstitutionServiceImpl implements SubstitutionService {

    @Autowired SubstitutionRepository substitutionRepository

    @Autowired SubstitutionValidator substitutionValidator

    @Override
    Substitution save(Substitution substitution) throws SubstitutionValidationException {

        substitutionValidator.validate(substitution)

        substitutionRepository.save(substitution)
    }

    @Override
    Substitution findByCode(SubstitutionCode code) throws SubstitutionNotFoundException {

        def substitution = substitutionRepository.findOne(code)

        if (substitution == null) {
            throw new SubstitutionNotFoundException("Could not find Substitution with Code [${ code}]")
        }

        substitution
    }
}