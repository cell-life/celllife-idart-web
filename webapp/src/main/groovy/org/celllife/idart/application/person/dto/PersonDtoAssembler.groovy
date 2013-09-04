package org.celllife.idart.application.person.dto

import org.celllife.idart.domain.person.Person

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
class PersonDtoAssembler {

    static Person toPerson(PersonDto personDto) {
        def person = new Person()
        person.with {
            firstName = personDto.firstName
            middleNames = personDto.middleNames
            lastName = personDto.lastName
            personalTitle = personDto.personalTitle
            suffix = personDto.suffix
            nickname = personDto.nickname
            gender = personDto.gender
            birthDate = personDto.birthDate
            mothersMaidenName = personDto.mothersMaidenName
            maritalStatus = personDto.maritalStatus
            totalYearsWorkExperience = personDto.totalYearsWorkExperience
            comment = personDto.comment
            measurements = personDto.measurements
        }
        person
    }
}
