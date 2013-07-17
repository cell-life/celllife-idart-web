package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 15h26
 */
public interface RawMaterialService {

    RawMaterial save(RawMaterial rawMaterial)

    RawMaterial findByIdentifiers(Set<Identifier> identifiers)

}