package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId
import org.celllife.idart.common.PartType


/**
 */
public interface PartRepository {

    boolean exists(PartId partId)

    Part save(Part part)

    Part findOne(PartId partId)

    Collection<PartId> findByClass(Class<? extends Part> clazz);

    PartId findByLabelValue(String labelValue)
}
