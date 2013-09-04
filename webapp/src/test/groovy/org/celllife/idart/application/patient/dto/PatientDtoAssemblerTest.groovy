package org.celllife.idart.application.patient.dto

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.PersonId
import org.junit.Test

import static org.celllife.idart.application.patient.dto.PatientDtoAssembler.getPerson
import static org.celllife.idart.common.AuthorityId.getIDART
import static org.celllife.idart.common.Gender.MALE
import static org.celllife.idart.common.MaritalStatus.MARRIED
import static org.celllife.idart.common.Measurement.newMeasurement
import static org.celllife.idart.common.MeasurementType.HIEGHT
import static org.celllife.idart.common.Quantity.newQuantity
import static org.celllife.idart.common.UnitOfMeasureCode.newUnitOfMeasureCode
import static org.celllife.idart.domain.identifiable.Identifier.newIdentifier
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 10h04
 */
class PatientDtoAssemblerTest {


    @Test
    public void shouldMap() throws Exception {

        def today = new Date()

        def personDto = new PersonDto()
        personDto.with {
            identifiers = [newIdentifier(IDART, 0)]
            firstName = "Geoff"
            middleNames = "Ernest"
            lastName = "Vader"
            personalTitle = "Mr"
            suffix = "Jnr"
            nickname = "Geoffie"
            gender = MALE
            birthDate = today
            mothersMaidenName = "Skywalker"
            maritalStatus = MARRIED
            totalYearsWorkExperience = 10
            comment = "The force is strong with this one"
            measurements = newMeasurements(today)
        }

        def person = getPerson(personDto, PersonId.valueOf("000001"))
        assertNotNull(person)
        assertEquals("Geoff", person.firstName)
        assertEquals("Ernest", person.middleNames)
        assertEquals("Vader", person.lastName)
        assertEquals("Mr", person.personalTitle)
        assertEquals("Jnr", person.suffix)
        assertEquals("Geoffie", person.nickname)
        assertEquals(MALE, person.gender)
        assertEquals(today, person.birthDate)
        assertEquals("Skywalker", person.mothersMaidenName)
        assertEquals(MARRIED, person.maritalStatus)
        assertEquals(10L, person.totalYearsWorkExperience)
        assertEquals("The force is strong with this one", person.comment)
        def measurements = newMeasurements(today)
        assertEquals(measurements, person.measurements)

    }

    static newMeasurements(Date today) {
        [newMeasurement(HIEGHT, newQuantity(160, newUnitOfMeasureCode("cm")), today)] as Set
    }
}
