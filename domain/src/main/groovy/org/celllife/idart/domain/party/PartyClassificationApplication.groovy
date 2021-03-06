package org.celllife.idart.domain.party

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import org.celllife.idart.common.PartyClassificationCode
import org.celllife.idart.common.Period

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
@EqualsAndHashCode
@ToString
class PartyClassificationApplication implements Serializable {

    /**
     * Application of
     */
    PartyClassificationCode classification

    /**
     * Valid during
     */
    Period valid

}
