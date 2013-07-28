package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 22h10
 */
@Mixin([Codeable, Nameable, Describable])
class AdministrationMethod {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/methods"

    static final String DEFAULT_SYSTEM = "2.16.840.1.113883.12.165"

    /**
     * Persistence Key
     */
    String pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
