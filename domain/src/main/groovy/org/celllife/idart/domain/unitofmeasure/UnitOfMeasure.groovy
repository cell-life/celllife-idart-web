package org.celllife.idart.domain.unitofmeasure

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
class UnitOfMeasure implements Persistable<String> {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/unitsOfMeasure"

    static final String DEFAULT_SYSTEM = "http://unitsofmeasure.org"

    /**
     * Persistence Key
     */
    String pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    UnitOfMeasureType type
}


