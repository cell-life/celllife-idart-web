package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
@EqualsAndHashCode
class PartClassification {

    PartClassificationType type

    String code

    Date fromDate

    Date thruDate

}
