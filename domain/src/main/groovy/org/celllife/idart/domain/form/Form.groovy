package org.celllife.idart.domain.form

import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Mixin([Codeable, Nameable, Describable])
class Form {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/forms"

    static final String DEFAULT_SYSTEM = "2.16.840.1.113883.19.5.3"

    /**
     * Persistence Key
     */
    String pk

    Set<Code> codes = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

}
