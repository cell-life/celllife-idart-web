package org.celllife.idart.domain.partclassification

import org.celllife.idart.common.PartClassificationCode
import org.celllife.idart.common.PartClassificationType

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h22
 */
class PartClassification {

    /**
     * Identified by
     */
    PartClassificationCode code

    /**
     * Described as
     */
    String description

    /**
     * Has Parent Identified by
     */
    PartClassificationCode parent

}
