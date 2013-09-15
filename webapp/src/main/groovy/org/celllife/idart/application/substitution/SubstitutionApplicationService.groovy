package org.celllife.idart.application.substitution

import org.celllife.idart.application.substitution.dto.SubstitutionDto
import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SubstitutionApplicationService {

    Boolean exists(SubstitutionCode substitutionCode)

    SubstitutionCode save(SubstitutionDto substitutionDto)

    SubstitutionDto findBySubstitutionCode(SubstitutionCode substitutionCode)

    SubstitutionDto findByIdentifier(Identifier identifier)

}
