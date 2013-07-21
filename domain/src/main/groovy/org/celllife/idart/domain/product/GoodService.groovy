package org.celllife.idart.domain.product

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface GoodService {

    Good save(Good good)

    Iterable<Good> findAll()

    Good findByIdentifier(String identifier)

    Good findByIdentifiers(Iterable<Identifier> identifiers)

}