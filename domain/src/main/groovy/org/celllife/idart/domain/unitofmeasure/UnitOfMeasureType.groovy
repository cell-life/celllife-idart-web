package org.celllife.idart.domain.unitofmeasure

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.LocalisedText
import org.celllife.idart.domain.common.Nameable

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 20h05
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
@Mixin([Nameable])
class UnitOfMeasureType {

    /**
     * Persistence Key
     */
    Long pk

    Set<LocalisedText> names = []

}


