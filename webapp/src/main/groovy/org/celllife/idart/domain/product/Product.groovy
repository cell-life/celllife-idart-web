package org.celllife.idart.domain.product

import org.celllife.idart.domain.common.Nameable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.concept.LocalisedText

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h13
 */
@Mixin([Nameable])
abstract class Product implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    Set<LocalisedText> names = []

}
