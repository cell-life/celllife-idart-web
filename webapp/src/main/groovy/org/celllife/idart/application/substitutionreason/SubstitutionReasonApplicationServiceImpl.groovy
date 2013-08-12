package org.celllife.idart.application.substitutionreason

import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidationException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonNotFoundException
import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class SubstitutionReasonApplicationServiceImpl implements SubstitutionReasonApplicationService {

    @Autowired SubstitutionReasonService substitutionReasonService

    SubstitutionReason save(SubstitutionReason substitutionReason) throws SubstitutionReasonValidationException {
        substitutionReasonService.save(substitutionReason)
    }

    SubstitutionReason findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) throws SubstitutionReasonNotFoundException{
        substitutionReasonService.findBySubstitutionReasonCode(substitutionReasonCode)
    }

}