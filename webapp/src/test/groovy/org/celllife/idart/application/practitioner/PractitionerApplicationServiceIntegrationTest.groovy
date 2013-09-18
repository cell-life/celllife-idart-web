package org.celllife.idart.application.practitioner

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.organisation.OrganisationApplicationService
import org.celllife.idart.application.organisation.dto.LegalOrganisationDto
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.common.Period
import org.celllife.idart.domain.counter.CounterRepository
import org.celllife.idart.domain.facility.FacilityRepository
import org.celllife.idart.domain.identifiable.IdentifiableRepository
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.organisation.OrganisationRepository
import org.celllife.idart.domain.person.PersonRepository
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerRepository
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.infrastructure.springdata.counter.SpringDataCounterRepository
import org.celllife.idart.infrastructure.springdata.facility.SpringDataFacilityRepository
import org.celllife.idart.infrastructure.springdata.facilityorganisation.SpringDataFacilityOrganisationRepository
import org.celllife.idart.infrastructure.springdata.identifiable.SpringDataIdentifiableRepository
import org.celllife.idart.infrastructure.springdata.organisation.SpringDataOrganisationRepository
import org.celllife.idart.infrastructure.springdata.person.SpringDataPersonRepository
import org.celllife.idart.infrastructure.springdata.practitioner.SpringDataPractitionerRepository
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationRepository
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.test.TestConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.inject.Inject

import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.PractitionerId.practitionerId
import static org.celllife.idart.common.PractitionerType.PHARMACIST
import static org.celllife.idart.common.IdentifiableType.PRACTITIONER
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 21h15
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PractitionerApplicationServiceIntegrationTest {

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PractitionerService practitionerService

    @Inject PractitionerRepository practitionerRepository

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

        ((SpringDataPractitionerRepository) practitionerRepository).deleteAll()

        ((SpringDataOrganisationRepository) organisationRepository).deleteAll()

        ((SpringDataFacilityRepository) facilityRepository).deleteAll()

        ((SpringDataFacilityOrganisationRepository) facilityOrganisationRepository).deleteAll()

    }

    /**
     * Scenario 1 - Both Practitioner and Person exists
     *
     * @throws Exception
     */
    @Test
    public void shouldSavePractitionerScenario1() throws Exception {

        def practitionerDto = new PractitionerDto()
        practitionerDto.with {
            identifiers = [
                    newIdentifier(systemId("00000001"), "00000002"),
            ]

            type = PHARMACIST

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def firstPractitionerId = practitionerApplicationService.save(practitionerDto)
        assertNotNull(firstPractitionerId)

        def secondPractitionerId = practitionerApplicationService.save(practitionerDto)
        assertNotNull(secondPractitionerId)

        assertEquals(firstPractitionerId, secondPractitionerId)
    }

    /**
     * Scenario 2 - Practitioner exists but Person does not
     *
     * @throws Exception
     */
    @Test(expected = PractitionerWithoutAPersonException)
    public void shouldSavePractitionerScenario2() throws Exception {

        def practitionerIdentifiers = [
                newIdentifier(IDART_WEB.id, "00000000"),
                newIdentifier(systemId("00000001"), "00000002")
        ]

        identifiableService.resolveIdentifiable(PRACTITIONER, practitionerIdentifiers as Set<Identifier>)

        def practitioner = new Practitioner()
        practitioner.with {
            id = practitionerId("00000000")
            type = PHARMACIST
            valid = new Period(fromDate: new Date())
            person = personId("00000001")
        }

        practitionerService.save(practitioner)

        def practitionerDto = new PractitionerDto()
        practitionerDto.with {
            identifiers = [
                    newIdentifier(systemId("00000001"), "00000002"),
            ]

            type = PHARMACIST

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        practitionerApplicationService.save(practitionerDto)
    }

    /**
     * Scenario 3 - Practitioner does not exist, but Person does
     *
     * @throws Exception
     */
    @Test
    public void shouldSavePractitionerScenario3() throws Exception {

        def personDto = new PersonDto()
        personDto.with {
            identifiers = [
                    newIdentifier(systemId("00000001"), "00000002"),
            ]
            firstName = "Geoff"
            lastName = "Vader"
        }

        personApplicationService.save(personDto)

        def practitionerDto = new PractitionerDto()
        practitionerDto.with {
            identifiers = [
                    newIdentifier(systemId("00000003"), "00000004"),
            ]

            type = PHARMACIST

            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000001"), "00000002"),
                ]
                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def practitionerId = practitionerApplicationService.save(practitionerDto)
        assertNotNull(practitionerId)
    }

    /**
     * Scenario 4 - Practitioner and Person don't exist
     *
     * @throws Exception
     */
    @Test
    public void shouldSavePractitionerScenario4() throws Exception {

        def practitionerDto = new PractitionerDto()
        practitionerDto.with {

            identifiers = [
                    newIdentifier(systemId("00000001"), "00000002")
            ]

            type = PHARMACIST

            person = new PersonDto()
            person.with {

                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004")
                ]

                firstName = "Geoff"
                lastName = "Vader"
            }
        }

        def practitionerId = practitionerApplicationService.save(practitionerDto)
        assertNotNull(practitionerId)
    }

    @Test
    public void shouldFindByFacility() throws Exception {

        def organisation = new LegalOrganisationDto()
        organisation.with {
            name = "Cape Town Metropolitan Municipality"
            taxRegistrationNumber = "00/0/0000/0000"
        }

        def organisationId = organisationApplicationService.save(organisation)

        def facility = new FacilityDto()
        facility.with {
            identifiers = [
                    newIdentifier(PREHMIS.id, "WES")
            ]
        }

        def facilityId = facilityApplicationService.save(facility)

        facilityOrganisationService.save(facilityId, organisationId, OPERATED_BY)

        def practitioners = practitionerApplicationService.findByFacility(facilityId)

        practitioners.each { practitioner ->
            println toJson(practitioner)
        }
    }

    def String toJson(PractitionerDto practitioner) {
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(practitioner)
    }
}
