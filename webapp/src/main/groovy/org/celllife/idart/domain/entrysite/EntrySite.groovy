package org.celllife.idart.domain.entrysite

import org.celllife.idart.domain.common.Codeable
import org.celllife.idart.domain.common.Describable
import org.celllife.idart.domain.common.Nameable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.concept.Code
import org.celllife.idart.domain.concept.LocalisedText

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Mixin([Codeable, Nameable, Describable])
class EntrySite implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
