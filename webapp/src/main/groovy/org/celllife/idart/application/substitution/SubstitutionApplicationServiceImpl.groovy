package org.celllife.idart.application.substitution

import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitution.SubstitutionValidationException
import org.celllife.idart.domain.substitution.SubstitutionNotFoundException
import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.substitution.SubstitutionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubstitutionApplicationServiceImpl implements SubstitutionApplicationService {

    @Autowired SubstitutionService substitutionService

    Substitution save(Substitution substitution) throws SubstitutionValidationException {
        substitutionService.save(substitution)
    }

    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode) throws SubstitutionNotFoundException{
        substitutionService.findBySubstitutionCode(substitutionCode)
    }

}