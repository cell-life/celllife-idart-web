package org.celllife.idart.domain.facility

import org.celllife.idart.domain.common.*
import org.celllife.idart.domain.concept.Identifier
import org.celllife.idart.domain.concept.LocalisedText

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h03
 */
@Mixin([Identifiable, Nameable, Describable])
abstract class Facility implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

    Quantity area

}
