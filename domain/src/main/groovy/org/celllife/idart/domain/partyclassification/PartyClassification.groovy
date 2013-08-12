package org.celllife.idart.domain.partyclassification

import org.celllife.idart.common.PartyClassificationCode
import org.celllife.idart.common.PartyClassificationType

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h30
 */
class PartyClassification {

    /**
     * Identified by
     */
    PartyClassificationCode code

    /**
     * Described as
     */
    String description

    /**
     * Has Parent Identified by
     */
    PartyClassificationCode parent

}
