package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId
import org.celllife.idart.common.PartType

import javax.annotation.Generated

/**
 */
public interface PartRepository {

    boolean exists(PartId partId)

    Part save(Part part)

    Part findOne(PartId partId)

    Collection<Part> findByClass(Class<? extends Part> clazz);
}
