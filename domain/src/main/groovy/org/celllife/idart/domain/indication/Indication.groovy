package org.celllife.idart.domain.indication

import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h54
 */
@Mixin([Codeable, Nameable, Describable])
class Indication implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
