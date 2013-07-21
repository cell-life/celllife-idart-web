package org.celllife.idart.domain.routeofadministration

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Mixin([Codeable, Nameable, Describable])
class RouteOfAdministration implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
