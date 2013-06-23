package org.celllife.idart.domain.person;

import org.celllife.idart.udm.MaritalStatus;
import org.celllife.idart.udm.common.Gender;
import org.celllife.idart.udm.party.Party;
import org.celllife.idart.udm.physicalcharacteristic.PhysicalCharacteristic;

import java.util.Date;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h50
 */
public final class Person extends Party {

    /**
     * First Name
     */
    private String firstName;

    /**
     * Middle Names
     */
    private String middleNames;

    /**
     * Last Name
     */
    private String lastName;

    /**
     * Personal Title
     */
    private String personalTitle;

    /**
     * Suffix
     */
    private String suffix;

    /**
     * Nickname
     */
    private String nickname;

    /**
     * Gender
     */
    private Gender gender;

    /**
     * Birth date
     */
    private Date birthDate;

    /**
     * Mother's Maiden Name
     * TODO Should be encrypted
     */
    private String mothersMaidenName;

    /**
     * Marital Status
     */
    private MaritalStatus maritalStatus;

    /**
     * Total Years Work Experience
     */
    private Integer totalYearsWorkExperience;

    /**
     * Comment
     */
    private String comment;

    /**
     * having
     */
    private Set<PhysicalCharacteristic> physicalCharacteristics;

    public Person() {
    }

}
