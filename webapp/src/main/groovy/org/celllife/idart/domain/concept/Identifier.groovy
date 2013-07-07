package org.celllife.idart.domain.concept

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Identifier {

    String system

    String value

    Period valid

}