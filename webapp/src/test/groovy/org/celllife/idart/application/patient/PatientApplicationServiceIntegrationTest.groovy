package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.Period
import org.celllife.idart.domain.counter.CounterRepository
import org.celllife.idart.domain.identifiable.IdentifiableRepository
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientRepository
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.PersonRepository
import org.celllife.idart.infrastructure.springdata.counter.SpringDataCounterRepository
import org.celllife.idart.infrastructure.springdata.identifiable.SpringDataIdentifiableRepository
import org.celllife.idart.infrastructure.springdata.patient.SpringDataPatientRepository
import org.celllife.idart.infrastructure.springdata.person.SpringDataPersonRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.AuthorityId.newAuthorityId
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.domain.identifiable.Identifiable.newIdentifiable
import static org.celllife.idart.domain.identifiable.IdentifiableType.PATIENT
import static org.celllife.idart.domain.identifiable.Identifier.newIdentifier
import static org.junit.Assert.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-28
 * Time: 19h19
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = TestConfiguration)
class PatientApplicationServiceIntegrationTest {

    @Autowired PatientApplicationService patientApplicationService

    @Autowired PatientService patientService

    @Autowired PatientRepository patientRepository

    @Autowired PersonApplicationService personApplicationService

    @Autowired PersonRepository personRepository

    @Autowired IdentifiableRepository identifiableRepository

    @Autowired IdentifiableService identifiableService

    @Autowired CounterRepository counterRepository

    @Before
    public void setUp() throws Exception {

        ((SpringDataCounterRepository) counterRepository).deleteAll()

        ((SpringDataIdentifiableRepository) identifiableRepository).deleteAll()

        ((SpringDataPersonRepository) personRepository).deleteAll()

        ((SpringDataPatientRepository) patientRepository).deleteAll()

    }

    /**
     * Scenario 1 - Both Patient and Person exists
     *
     * @throws Exception
     */
    @Test
    public void shouldSavePatientScenario1() throws Exception {

        def patientDto = new PatientDto()
        patientDto.with {
            identifiers = [
                    newIdentifier(newAuthorityId("00000001"), "00000002"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(newAuthorityId("00000003"), "00000004"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def firstPatientId = patientApplicationService.save(patientDto)
        assertNotNull(firstPatientId)

        def secondPatientId = patientApplicationService.save(patientDto)
        assertNotNull(secondPatientId)

        assertEquals(firstPatientId, secondPatientId)
    }

    /**
     * Scenario 2 - Patient exists but Person does not
     *
     * @throws Exception
     */
    @Test(expected = PatientWithoutAPersonException)
    public void shouldSavePatientScenario2() throws Exception {

        def identifiable = newIdentifiable(PATIENT)
        identifiable.addIdentifier(newIdentifier(IDART, "00000000"))
        identifiable.addIdentifier(newIdentifier(newAuthorityId("00000001"), "00000002"))
        identifiableService.save(identifiable)

        def patient = new Patient()
        patient.with {
            id = patientId("00000000")
            valid = new Period(fromDate: new Date())
        }
        patientService.save(patient)


        def patientDto = new PatientDto()
        patientDto.with {
            identifiers = [
                    newIdentifier(newAuthorityId("00000001"), "00000002"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(newAuthorityId("00000003"), "00000004"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        patientApplicationService.save(patientDto)
    }

    /**
     * Scenario 3 - Patient does not exist, but Person does
     *
     * @throws Exception
     */
    @Test
    public void shouldSavePatientScenario3() throws Exception {

        def personDto = new PersonDto()
        personDto.with {
            identifiers = [
                    newIdentifier(newAuthorityId("00000001"), "00000002"),
            ]
            firstName = "Geoff"
            lastName = "Vader"
        }

        personApplicationService.save(personDto)

        def patientDto = new PatientDto()
        patientDto.with {
            identifiers = [
                    newIdentifier(newAuthorityId("00000003"), "00000004"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(newAuthorityId("00000001"), "00000002"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def patientId = patientApplicationService.save(patientDto)
        assertNotNull(patientId)
    }

    /**
     * Scenario 4 - Patient and Person don't exist
     *
     * @throws Exception
     */
    @Test
    public void shouldSavePatientScenario4() throws Exception {

        def patientDto = new PatientDto()
        patientDto.with {
            identifiers = [
                    newIdentifier(newAuthorityId("00000001"), "00000002"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(newAuthorityId("00000003"), "00000004"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def patientId = patientApplicationService.save(patientDto)
        assertNotNull(patientId)
    }
}
