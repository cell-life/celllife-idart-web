package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.common.PartId
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.PartType

import javax.annotation.Generated

/**
 */
interface PartApplicationService {

    Boolean exists(PartId partId)

    PartId save(PartDto partDto)

    PartDto findByPartId(PartId partId)

    PartDto findByIdentifier(Identifier identifier)

    PartId findByIdentifiers(Set<Identifier> identifiers)

    Set<PartDto> findByType(PartType type)
}
