package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode
import org.celllife.idart.common.PartClassificationCode
import org.celllife.idart.common.Period

/**
 * Classification code of a Part, and the validity of the code. An example of a code is ATC
 */
@EqualsAndHashCode
class PartClassificationApplication implements Serializable {

    /**
     * Application of
     */
    PartClassificationCode classification

    /**
     * Valid during
     */
    Period valid

    @Override
    public String toString() {
        return "PartClassificationApplication [classification=" + classification + ", valid=" + valid + "]";
    }
}
