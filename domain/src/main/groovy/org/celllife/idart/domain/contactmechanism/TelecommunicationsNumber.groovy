package org.celllife.idart.domain.contactmechanism

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 23h20
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
class TelecommunicationsNumber extends ContactMechanism {

    String areaCode

    String contactNumber

    String countryCode

}
