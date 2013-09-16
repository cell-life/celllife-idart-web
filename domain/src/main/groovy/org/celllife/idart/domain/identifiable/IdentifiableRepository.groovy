package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.SystemId
import org.celllife.idart.common.IdentifiableType

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h40
 */
interface IdentifiableRepository {

    Identifiable save(Identifiable identifiable)

    Identifiable findByTypeAndSystemAndValue(IdentifiableType type, SystemId system, String value)

}