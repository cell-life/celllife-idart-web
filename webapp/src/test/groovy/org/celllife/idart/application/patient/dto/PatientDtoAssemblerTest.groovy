package org.celllife.idart.application.patient.dto

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.person.dto.PersonDtoAssembler
import org.celllife.idart.common.UnitsOfMeasure
import org.junit.Test

import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Gender.MALE
import static org.celllife.idart.common.MaritalStatus.MARRIED
import static org.celllife.idart.common.Measurement.newMeasurement
import static org.celllife.idart.common.MeasurementType.HIEGHT
import static org.celllife.idart.common.Quantity.newQuantity
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 10h04
 */
class PatientDtoAssemblerTest {

    private PersonDtoAssembler personDtoAssembler = new PersonDtoAssembler()

    @Test
    public void shouldMap() throws Exception {

        def today = new Date()

        def personDto = new PersonDto()
        personDto.with {
            identifiers = [newIdentifier(IDART_WEB.id, "00000")]
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

        def person = personDtoAssembler.toPerson(personDto)
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
        [newMeasurement(HIEGHT, newQuantity(160, UnitsOfMeasure.cm.code), today)] as Set
    }
}
