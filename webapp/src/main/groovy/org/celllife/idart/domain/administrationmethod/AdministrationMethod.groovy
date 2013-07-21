package org.celllife.idart.domain.administrationmethod

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 22h10
 */
@Mixin([Codeable, Nameable, Describable])
class AdministrationMethod implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
