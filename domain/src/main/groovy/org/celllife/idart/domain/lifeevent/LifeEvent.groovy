package org.celllife.idart.domain.lifeevent

import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Mixin([Codeable, Nameable, Describable])
class LifeEvent implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
