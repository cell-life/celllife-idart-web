package org.celllife.idart.domain.product

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h26
 */
public interface GoodService {

    Good save(Good good)

    Good findByIdentifiers(Set<Identifier> identifiers)
}