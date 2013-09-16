package org.celllife.idart.application.indication

import org.celllife.idart.application.indication.dto.IndicationDto
import org.celllife.idart.common.IndicationCode
import org.celllife.idart.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface IndicationApplicationService {

    Boolean exists(IndicationCode indicationCode)

    IndicationCode save(IndicationDto indicationDto)

    IndicationDto findByIndicationCode(IndicationCode indicationCode)

    IndicationDto findByIdentifier(Identifier identifier)

    IndicationCode findByIdentifiers(Set<Identifier> identifiers)

}
