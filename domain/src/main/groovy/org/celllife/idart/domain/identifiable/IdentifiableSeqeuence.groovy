package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 18h09
 */
interface IdentifiableSeqeuence {

    Identifier nextValue(IdentifiableType type)

}
