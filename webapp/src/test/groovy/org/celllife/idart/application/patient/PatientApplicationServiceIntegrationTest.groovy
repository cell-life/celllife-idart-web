package org.celllife.idart.application.patient

import org.celllife.idart.common.FacilityId;
import org.celllife.idart.common.SystemId;

import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.organisation.OrganisationApplicationService
import org.celllife.idart.application.organisation.dto.LegalOrganisationDto
import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.patient.PatientWithoutAPersonException
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.system.dto.SystemDto
import org.celllife.idart.application.system.SystemApplicationService
import org.celllife.idart.application.systemfacility.SystemFacilityApplicationService
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
import org.celllife.idart.domain.system.SystemRepository
import org.celllife.idart.domain.system.SystemService
import org.celllife.idart.infrastructure.springdata.counter.SpringDataCounterRepository
import org.celllife.idart.infrastructure.springdata.facility.SpringDataFacilityRepository
import org.celllife.idart.infrastructure.springdata.facilityorganisation.SpringDataFacilityOrganisationRepository
import org.celllife.idart.infrastructure.springdata.identifiable.SpringDataIdentifiableRepository
import org.celllife.idart.infrastructure.springdata.organisation.SpringDataOrganisationRepository
import org.celllife.idart.infrastructure.springdata.patient.SpringDataPatientRepository
import org.celllife.idart.infrastructure.springdata.person.SpringDataPersonRepository
import org.celllife.idart.infrastructure.springdata.system.SpringDataSystemRepository
import org.celllife.idart.infrastructure.springdata.systemfacility.SpringDataSystemFacilityRepository
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationRepository
import org.celllife.idart.relationship.facilityorganisation.FacilityOrganisationService
import org.celllife.idart.relationship.systemfacility.SystemFacilityRepository
import org.celllife.idart.relationship.systemfacility.SystemFacilityService
import org.celllife.idart.relationship.systemfacility.SystemFacility;

import org.celllife.idart.test.TestConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.inject.Inject

import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.IdentifiableType.PATIENT
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.celllife.idart.relationship.systemfacility.SystemFacility.Relationship.DEPLOYED_AT
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

    @Inject SystemApplicationService systemApplicationService
    
    @Inject SystemRepository systemRepository

    @Inject SystemFacilityService systemFacilityService
    
    @Inject SystemFacilityRepository systemFacilityRepository

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
        
        ((SpringDataSystemRepository) systemRepository).deleteAll()
        
        ((SpringDataSystemFacilityRepository) systemFacilityRepository).deleteAll()

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
                newIdentifier("00000000"),
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
        System.out.println("organisation="+organisation.identifiers);
        System.out.println("organisationId="+organisationId);

        def facility = new FacilityDto()
        facility.with {
            identifiers = [
                    newIdentifier(PREHMIS.id, "WES")
            ]
        }
        
        def facilityId = facilityApplicationService.save(facility)
        System.out.println("facility="+facility.identifiers)
        System.out.println("facilityId="+facilityId)

        facilityOrganisationService.save(facilityId, organisationId, OPERATED_BY)

        ["72254311", "17768102", "17768102"].each { patientIdentifier ->
            patientApplicationService.findByIdentifierAndFacility(patientIdentifier, facilityId).each { patient ->
                println toJson(patient)
            }
        }
    }

    @Test
    public void shouldntCreateDuplicatePatients() throws Exception {

        // setup first organisation
        def organisation1 = new LegalOrganisationDto()
        organisation1.with {
            name = "Cape Town Metropolitan Municipality"
            taxRegistrationNumber = "00/0/0000/0000"
        }

        def organisation1Id = organisationApplicationService.save(organisation1)
        System.out.println("organisation1="+organisation1.identifiers);
        System.out.println("organisation1Id="+organisation1Id);

        def facility1 = new FacilityDto()
        facility1.with {
            identifiers = [
                    newIdentifier(PREHMIS.id, "WES")
            ]
        }
        
        def facility1Id = facilityApplicationService.save(facility1)
        System.out.println("facility1="+facility1.identifiers)
        System.out.println("facility1Id="+facility1Id)
        
        facilityOrganisationService.save(facility1Id, organisation1Id, OPERATED_BY)

        def system1 = new SystemDto()
        system1.with {
            applicationKey = "E8246BF0-B058-440C-A3D4-783F1A983722"
        }
        def system1Id = systemApplicationService.save(system1)
        System.out.println("system1="+system1.identifiers)
        System.out.println("system1Id="+system1Id)
        
        systemFacilityService.save(system1Id, facility1Id, DEPLOYED_AT);

        // setup second organisation
        def organisation2 = new LegalOrganisationDto()
        organisation2.with {
            name = "Cape Town Metropolitan Municipality"
            taxRegistrationNumber = "00/0/0000/0000"
        }

        def organisation2Id = organisationApplicationService.save(organisation1)
        System.out.println("organisation2="+organisation2.identifiers);
        System.out.println("organisation2Id="+organisation2Id);

        def facility2 = new FacilityDto()
        facility2.with {
            identifiers = [
                    newIdentifier(PREHMIS.id, "WES")
            ]
        }
        
        def facility2Id = facilityApplicationService.save(facility2)
        System.out.println("facility2="+facility2.identifiers)
        System.out.println("facility2Id="+facility2Id)

        facilityOrganisationService.save(facility2Id, organisation2Id, OPERATED_BY)

        def system2 = new SystemDto()
        system2.with {
            applicationKey = "E8246BF0-B058-440C-A3D4-783F1A983723"
        }
        def system2Id = systemApplicationService.save(system2)
        System.out.println("system2="+system2.identifiers)
        System.out.println("system2Id="+system2Id)
        
        systemFacilityService.save(system2Id, facility2Id, DEPLOYED_AT);

        // 1st facility does a patient search 
        Set<PatientDto> patients1 = patientApplicationService.findByIdentifierAndSystem("72254311", system1Id);
        assertNotNull(patients1)
        assertEquals(1, patients1.size())
        PatientDto patientDto1 = patients1.iterator().next()
        println toJson(patientDto1)
        
        // 2nd facility does a patient search
        Set<PatientDto> patients2 = patientApplicationService.findByIdentifierAndSystem("72254311", system2Id);
        assertNotNull(patients2)
        assertEquals(1, patients2.size())
        PatientDto patientDto2 = patients2.iterator().next()
        println toJson(patientDto2)
        
        // check they are the same
        assertEquals(patientDto1,patientDto2)
    }

    def String toJson(PatientDto patient) {
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient)
    }
}
