package org.celllife.idart.domain.party

import groovy.transform.EqualsAndHashCode
import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h45
 */
@EqualsAndHashCode(includes = "ids")
abstract class Party {

    /**
     * Classified into
     */
    Set<PartyClassificationApplication> classifications = []

    /**
     * Contactable via
     */
    Set<PartyContactMechanism> contactMechanisms = []

    def merge(Party that) {

        if (that.classifications != null) {
            this.classifications.addAll(that.classifications)
        }

        if (that.contactMechanisms != null) {
            this.contactMechanisms.addAll(that.contactMechanisms)
        }
    }
}
