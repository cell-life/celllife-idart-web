package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
@ToString
@EqualsAndHashCode
class Period {

    Date fromDate

    Date thruDate

    static Period newPeriod() {
        new Period(fromDate: new Date())
    }
}
