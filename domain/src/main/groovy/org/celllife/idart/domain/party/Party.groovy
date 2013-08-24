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
     * Contacted via
     */
    Set<PartyContactMechanism> contactMechanisms = []

    def merge(Party that) {
        this.classifications.addAll(that.classifications)
        this.contactMechanisms.addAll(that.contactMechanisms)
    }

    def addMobileTelephoneNumber(args) {

        if (args == null) {
            return
        }

        contactMechanisms << new PartyContactMechanism(
                contactMechanism: new MobileTelephoneNumber(
                        countryCode: args.countryCode,
                        contactNumber: args.contactNumber
                )
        )
    }
}
