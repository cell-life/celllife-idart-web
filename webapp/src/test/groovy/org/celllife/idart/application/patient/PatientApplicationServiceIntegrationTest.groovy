package org.celllife.idart.application.patient

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.organisation.OrganisationApplicationService
import org.celllife.idart.application.organisation.dto.LegalOrganisationDto
import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.Period
import org.celllife.idart.domain.counter.CounterRepository
import org.celllife.idart.domain.facility.FacilityRepository
import org.celllife.idart.domain.identifiable.IdentifiableRepository
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.organisation.OrganisationRepository
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientRepository
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.PersonRepository
import org.celllife.idart.infrastructure.springdata.counter.SpringDataCounterRepository
import org.celllife.idart.infrastructure.springdata.facility.SpringDataFacilityRepository
import org.celllife.idart.infrastructure.springdata.facilityorganisation.SpringDataFacilityOrganisationRepository
import org.celllife.idart.infrastructure.springdata.identifiable.SpringDataIdentifiableRepository
import org.celllife.idart.infrastructure.springdata.organisation.SpringDataOrganisationRepository
import org.celllife.idart.infrastructure.springdata.patient.SpringDataPatientRepository
import org.celllife.idart.infrastructure.springdata.person.SpringDataPersonRepository
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationRepository
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.test.TestConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.inject.Inject

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.SystemId.PREHMIS
import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.IdentifiableType.PATIENT
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.junit.Assert.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-28
 * Time: 19h19
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = TestConfiguration)
class PatientApplicationServiceIntegrationTest {

    @Inject PatientApplicationService patientApplicationService

    @Inject PatientService patientService

    @Inject PatientRepository patientRepository

    @Inject PersonApplicationService personApplicationService

    @Inject PersonRepository personRepository

    @Inject IdentifiableRepository identifiableRepository

    @Inject IdentifiableService identifiableService

    @Inject CounterRepository counterRepository

    @Inject FacilityApplicationService facilityApplicationService

    @Inject FacilityRepository facilityRepository

    @Inject OrganisationApplicationService organisationApplicationService

    @Inject OrganisationRepository organisationRepository

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject FacilityOrganisationRepository facilityOrganisationRepository

    @Inject ObjectMapper objectMapper

    @Before
    public void setUp() throws Exception {

        ((SpringDataCounterRepository) counterRepository).deleteAll()

        ((SpringDataIdentifiableRepository) identifiableRepository).deleteAll()

        ((SpringDataPersonRepository) personRepository).deleteAll()

        ((SpringDataPatientRepository) patientRepository).deleteAll()

        ((SpringDataOrganisationRepository) organisationRepository).deleteAll()

        ((SpringDataFacilityRepository) facilityRepository).deleteAll()

        ((SpringDataFacilityOrganisationRepository) facilityOrganisationRepository).deleteAll()

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
                    newIdentifier(systemId("00000001"), "00000002"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004"),
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

        def patientIdentifiers = [
                newIdentifier(IDART_WEB, "00000000"),
                newIdentifier(systemId("00000001"), "00000002")
        ]

        identifiableService.resolveIdentifiable(PATIENT, patientIdentifiers as Set<Identifier>)

        def patient = new Patient()
        patient.with {
            id = patientId("00000000")
            valid = new Period(fromDate: new Date())
            person = personId("00000005")
        }
        patientService.save(patient)


        def patientDto = new PatientDto()
        patientDto.with {
            identifiers = [
                    newIdentifier(systemId("00000001"), "00000002"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004"),
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
                    newIdentifier(systemId("00000001"), "00000002"),
            ]
            firstName = "Geoff"
            lastName = "Vader"
        }

        personApplicationService.save(personDto)

        def patientDto = new PatientDto()
        patientDto.with {
            identifiers = [
                    newIdentifier(systemId("00000003"), "00000004"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000001"), "00000002"),
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
                    newIdentifier(systemId("00000001"), "00000002"),
            ]

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def patientId = patientApplicationService.save(patientDto)
        assertNotNull(patientId)
    }

    @Test
    public void shouldFindByIdentifierFacility() throws Exception {

        def organisation = new LegalOrganisationDto()
        organisation.with {
            name = "Cape Town Metropolitan Municipality"
            taxRegistrationNumber = "00/0/0000/0000"
        }

        def organisationId = organisationApplicationService.save(organisation)

        def facility = new FacilityDto()
        facility.with {
            identifiers = [
                    newIdentifier(PREHMIS, "WES")
            ]
        }

        def facilityId = facilityApplicationService.save(facility)

        facilityOrganisationService.save(facilityId, organisationId, OPERATED_BY)

        ["72254311", "17768102", "17768102"].each { patientIdentifier ->
            patientApplicationService.findByIdentifierAndFacility(patientIdentifier, facilityId).each { patient ->
                println toJson(patient)
            }
        }
    }

    def String toJson(PatientDto patient) {
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient)
    }
}
