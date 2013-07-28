package org.celllife.idart.domain.party

import groovy.transform.EqualsAndHashCode
import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h45
 */
@EqualsAndHashCode(includes = "identifiers")
@Mixin([Identifiable])
abstract class Party {

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Classified into
     */
    Set<PartyClassificationApplication> classifications = []

    /**
     * Contacted via
     */
    Set<PartyContactMechanism> contactMechanisms = []

    def merge(Party that) {
        that.identifierSystems.each { system -> this.addIdentifier(system, that.getIdentifierValue(system)) }
        that?.classifications?.each { classification -> this.classifications << classification }
        that?.contactMechanisms?.each { contactMechanism -> this.contactMechanisms << contactMechanism }
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
