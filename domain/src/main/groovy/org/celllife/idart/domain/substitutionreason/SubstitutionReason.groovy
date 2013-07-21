package org.celllife.idart.domain.substitutionreason

import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h58
 */
@Mixin([Codeable, Nameable, Describable])
class SubstitutionReason implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}