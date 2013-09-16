package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h56
 */
public interface IdentifiableService {

    Identifiable resolveIdentifiable(IdentifiableType type, Set<Identifier> identifiers)

    Boolean exists(IdentifiableType type, Set<Identifier> identifiers)
}