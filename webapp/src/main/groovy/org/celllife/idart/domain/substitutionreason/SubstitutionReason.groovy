package org.celllife.idart.domain.substitutionreason

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h58
 */
@Mixin([Codeable, Nameable, Describable])
class SubstitutionReason implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
