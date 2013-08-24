package org.celllife.idart.client.person;

import org.celllife.idart.client.common.Gender;
import org.celllife.idart.client.common.Id;
import org.celllife.idart.client.common.MaritalStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h25
 */
public final class Person implements Serializable {

    public Set<Id> ids;

    public Set<PartyClassificationApplication> classifications;

    public Set<PartyContactMechanism> contactMechanisms;

    public String firstName;

    public String middleNames;

    public String lastName;

    public String personalTitle;

    public String suffix;

    public String nickname;

    public Gender gender;

    public Date birthDate;

    public String mothersMaidenName;

    public MaritalStatus maritalStatus;

    public Integer totalYearsWorkExperience;

    public String comment;

    public Set<PhysicalCharacteristic> physicalCharacteristics;

    public Person() {
    }
}
