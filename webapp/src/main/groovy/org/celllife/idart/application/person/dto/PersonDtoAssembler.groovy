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

    static def toPersonDto(Person person) {
        def personDto = new PersonDto()
        personDto.with {
            firstName = person.firstName
            middleNames = person.middleNames
            lastName = person.lastName
            personalTitle = person.personalTitle
            suffix = person.suffix
            nickname = person.nickname
            gender = person.gender
            birthDate = person.birthDate
            mothersMaidenName = person.mothersMaidenName
            maritalStatus = person.maritalStatus
            totalYearsWorkExperience = person.totalYearsWorkExperience
            comment = person.comment
            measurements = person.measurements
        }
        personDto
    }
}
