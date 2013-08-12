package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode
import org.celllife.idart.common.PartClassificationCode
import org.celllife.idart.common.Period

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
@EqualsAndHashCode
class PartClassificationApplication {

    /**
     * Application of
     */
    PartClassificationCode classification

    /**
     * Valid during
     */
    Period valid

}
