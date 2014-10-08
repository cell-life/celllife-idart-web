package org.celllife.idart.application.practitioner

import static org.celllife.idart.common.IdentifiableType.PRACTITIONER
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.PractitionerId.practitionerId
import static org.celllife.idart.common.PractitionerType.PHARMACIST
import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

import javax.inject.Inject

import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.organisation.OrganisationApplicationService
import org.celllife.idart.application.organisation.dto.LegalOrganisationDto
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.Period
import org.celllife.idart.domain.exception.ValidationException
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

import com.fasterxml.jackson.databind.ObjectMapper


@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = true)
class PractitionerApplicationServiceIntegrationTest {

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PractitionerService practitionerService

    @Inject PersonApplicationService personApplicationService

    @Inject IdentifiableService identifiableService

    @Inject FacilityApplicationService facilityApplicationService

    @Inject OrganisationApplicationService organisationApplicationService

    @Inject FacilityOrganisationService facilityOrganisationService

    @Inject ObjectMapper objectMapper
    
    @Test(expected=ValidationException)
    public void shouldThrowValidationException() throws Exception {

        def practitionerDto = new PractitionerDto()
        practitionerDto.with {
            identifiers = [
                    newIdentifier(systemId("00000001"), "00000002"),
            ]
            person = new PersonDto()
            person.with {
                identifiers = [
                        newIdentifier(systemId("00000003"), "00000004"),
                ]
            }
        }

        practitionerApplicationService.save(practitionerDto)
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
    @Test
    public void shouldSavePractitionerScenario2() throws Exception {

        def practitionerIdentifiers = [
                newIdentifier("00000000"),
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
