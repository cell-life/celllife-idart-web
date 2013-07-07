package org.celllife.idart.domain.product

import org.celllife.idart.domain.common.Codeable
import org.celllife.idart.domain.concept.Code
import org.celllife.idart.domain.part.FinishedGood

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h14
 */
@Mixin(Codeable)
class Good extends Product {

    Set<Code> codes = []

    /**
     * Offered using
     */
    FinishedGood finishedGood

}
