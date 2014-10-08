package org.celllife.idart.domain.partclassification

import groovy.transform.ToString

import org.celllife.idart.common.PartClassificationCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h22
 */
@ToString
class PartClassification implements Serializable {

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
