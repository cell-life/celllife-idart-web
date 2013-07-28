package org.celllife.idart.domain.common

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.validation.constraints.NotNull

@ToString
@EqualsAndHashCode(includes = "system")
class Identifier {

    String system

    String value

    Date fromDate

    Date thruDate

}