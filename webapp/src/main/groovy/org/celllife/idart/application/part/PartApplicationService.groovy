package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.common.PartId
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PartApplicationService {

    Boolean exists(PartId partId)

    PartId save(PartDto partDto)

    PartDto findByPartId(PartId partId)

    PartDto findByIdentifier(Identifier identifier)

}
