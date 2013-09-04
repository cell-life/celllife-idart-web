package org.celllife.idart.domain.person

import org.celllife.idart.common.Gender
import org.celllife.idart.common.MaritalStatus
import org.celllife.idart.common.Measurement
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.party.Party

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h50
 */
class Person extends Party {

    /**
     * Identified by
     */
    PersonId id

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

    def merge(Person that) {

        if (that == null) {
            return
        }

        super.merge(that)

        this.firstName = that.firstName
        this.middleNames = that.middleNames
        this.lastName = that.lastName
        this.personalTitle = that.personalTitle
        this.suffix = that.suffix
        this.nickname = that.nickname
        this.gender = that.gender
        this.birthDate = that.birthDate
        this.mothersMaidenName = that.mothersMaidenName
        this.maritalStatus = that.maritalStatus
        this.totalYearsWorkExperience = that.totalYearsWorkExperience
        this.comment = that.comment
        this.measurements.addAll(that.measurements)
    }

}
