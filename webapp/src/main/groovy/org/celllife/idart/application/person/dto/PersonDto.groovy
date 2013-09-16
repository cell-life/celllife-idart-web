package org.celllife.idart.application.person.dto

import org.celllife.idart.common.Gender
import org.celllife.idart.common.MaritalStatus
import org.celllife.idart.common.Measurement
import org.celllife.idart.domain.contactmechanism.ContactMechanism
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.party.PartyContactMechanism

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-23
 * Time: 18h35
 */
class PersonDto {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

    /**
     * First Name
     */
    String firstName

    /**
     * Middle Names
     */
    String middleNames

    /**
     * Last Name
     */
    String lastName

    /**
     * Personal Title
     */
    String personalTitle

    /**
     * Suffix
     */
    String suffix

    /**
     * Nickname
     */
    String nickname

    /**
     * Gender
     */
    Gender gender

    /**
     * Birth date
     */
    Date birthDate

    /**
     * Mother's Maiden Name
     * TODO Should be encrypted
     */
    String mothersMaidenName

    /**
     * Marital Status
     */
    MaritalStatus maritalStatus

    /**
     * Total Years Work Experience
     */
    Integer totalYearsWorkExperience

    /**
     * Comment
     */
    String comment

    /**
     * having
     */
    Set<Measurement> measurements = []

    /**
     * Contactable via
     */
    Set<PartyContactMechanism> contactMechanisms = []

    def addContactMechanism(ContactMechanism contactMechanism) {
        contactMechanisms << new PartyContactMechanism(contactMechanism: contactMechanism)
    }
}
