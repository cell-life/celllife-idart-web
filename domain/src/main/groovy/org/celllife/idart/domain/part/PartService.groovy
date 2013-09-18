package org.celllife.idart.domain.part

import org.celllife.idart.common.Label
import org.celllife.idart.common.PartId
import org.celllife.idart.common.PartType

/**
 */
public interface PartService {

    Boolean exists(PartId partId)

    Part save(Part part)

    Part findByPartId(PartId partId)

    Set<PartId> findByType(PartType type)

    PartId findByLabel(Label label)
}
