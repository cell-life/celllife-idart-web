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
class Product implements Persistable<String> {

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Name
     */
    String name

    def merge(Product that) {
        this.name = that.name
        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
    }

}
