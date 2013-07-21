package org.celllife.idart.domain.party

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.contactmechanism.ContactMechanism

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 23h31
 */
@ToString
@EqualsAndHashCode(includes = "contactMechanism")
class PartyContactMechanism {

    Date fromDate = new Date()

    Date thruDate

    Boolean nonSolicitationIndicator

    String extension

    String comment

    ContactMechanism contactMechanism

}
