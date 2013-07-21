package org.celllife.idart.domain.product

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
@Mixin(Identifiable)
class Product implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    def merge(Product that) {
        this.mergeIdentifiers(that)
    }

}
