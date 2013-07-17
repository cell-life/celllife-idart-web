package org.celllife.idart.application.part

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.part.Part

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 22h24
 */
public interface PartApplicationService {

    Part findByIdentifiers(Set<Identifier> identifiers)

}