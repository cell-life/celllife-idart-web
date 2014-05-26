package org.celllife.idart.domain.party

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h45
 */
@ToString
@EqualsAndHashCode(includes = "ids")
abstract class Party implements Serializable {

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
