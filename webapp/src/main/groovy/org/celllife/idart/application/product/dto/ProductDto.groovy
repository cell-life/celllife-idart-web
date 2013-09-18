package org.celllife.idart.application.product.dto

import org.celllife.idart.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h46
 */
abstract class ProductDto {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Name
     */
    String name

}
