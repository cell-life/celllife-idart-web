package org.celllife.idart.domain.concept

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.Duration
import org.celllife.idart.domain.lifeevent.LifeEvent

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h33
 */
@ToString
@EqualsAndHashCode
class Schedule {

    Set<Period> events

    Integer frequency

    LifeEvent when

    Duration duration

    Integer count

    Date end

}
