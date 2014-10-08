package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import org.celllife.idart.common.PartClassificationCode
import org.celllife.idart.common.Period

/**
 * Classification code of a Part, and the validity of the code. An example of a code is ATC
 */
@EqualsAndHashCode
@ToString
class PartClassificationApplication implements Serializable {

    /**
     * Application of
     */
    PartClassificationCode classification

    /**
     * Valid during
     */
    Period valid
}
