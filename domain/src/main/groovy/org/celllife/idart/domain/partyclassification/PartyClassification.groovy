package org.celllife.idart.domain.partyclassification

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.Codeable
import org.celllife.idart.domain.common.Describable
import org.celllife.idart.domain.common.LocalisedText

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h30
 */
@Mixin([Codeable, Describable])
abstract class PartyClassification {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    Set<LocalisedText> codes = []

    Set<LocalisedText> descriptions = []

    PartyClassification parent

}
