package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h26
 */
public interface FinishedGoodService {

    FinishedGood save(FinishedGood finishedGood)

    FinishedGood findByIdentifiers(Set<Identifier> identifiers)
}