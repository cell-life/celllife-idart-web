package org.celllife.idart.domain.unitofmeasure

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 20h05
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
@Mixin([Codeable, Nameable])
class UnitOfMeasure implements Persistable {

    /**
     * Persistence Key
     */
    @JsonIgnore Long pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    UnitOfMeasureType type

}


