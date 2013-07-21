package org.celllife.idart.domain.person

import org.celllife.idart.domain.common.Gender
import org.celllife.idart.domain.common.MaritalStatus
import org.celllife.idart.domain.party.Party

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h50
 */
class Person extends Party {

    static final String IDART_SYSTEM = "http://www.cell-life.org/idart/people"

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
    Set<PhysicalCharacteristic> physicalCharacteristics = []

    def merge(Person that) {
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
        that?.physicalCharacteristics?.each { physicalCharacteristic -> this.physicalCharacteristics << physicalCharacteristic }
    }

}
