package org.celllife.idart.application.substitutionreason

import org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDto
import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SubstitutionReasonApplicationService {

    Boolean exists(SubstitutionReasonCode substitutionReasonCode)

    SubstitutionReasonCode save(SubstitutionReasonDto substitutionReasonDto)

    SubstitutionReasonDto findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode)

    SubstitutionReasonDto findByIdentifier(Identifier identifier)

    SubstitutionReasonCode findByIdentifiers(Set<Identifier> identifiers)

}
