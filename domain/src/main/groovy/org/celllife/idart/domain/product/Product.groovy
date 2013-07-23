package org.celllife.idart.domain.product

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
@Mixin(Identifiable)
class Product implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Name
     */
    String name

    def merge(Product that) {
        this.mergeIdentifiers(that)
    }

}
