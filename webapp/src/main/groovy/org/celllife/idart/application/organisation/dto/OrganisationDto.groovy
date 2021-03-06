package org.celllife.idart.application.organisation.dto

import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.party.PartyClassificationApplication
import org.celllife.idart.domain.party.PartyContactMechanism

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h16
 */
abstract class OrganisationDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * Named as
     */
    String name

    /**
     * Classified into
     */
    Set<PartyClassificationApplication> classifications = []

    /**
     * Contactable via
     */
    Set<PartyContactMechanism> contactMechanisms = []

}
