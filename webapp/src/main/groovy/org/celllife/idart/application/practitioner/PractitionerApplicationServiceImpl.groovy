package org.celllife.idart.application.practitioner

import org.celllife.idart.application.ClinicNotFoundException
import org.celllife.idart.domain.assignment.AssignmentRepository
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicRepository
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.person.PersonRepository
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 12h16
 */
@Service class PractitionerApplicationServiceImpl implements PractitionerApplicationService {

    @Autowired ClinicRepository clinicRepository

    @Autowired PrehmisPractitionerApplicationService prehmisPractitionerApplicationService

    @Autowired PractitionerProvider prehmisPractitionerProvider

    @Autowired PractitionerService practitionerService

    @Autowired PersonRepository personRepository

    @Autowired AssignmentRepository assignmentRepository

    @Override
    List<Practitioner> findByClinicIdentifier(String applicationId, String clinicIdentifierValue) {

        Clinic clinic = clinicRepository.findOneByIdentifier("http://www.cell-life.org/idart/facility", clinicIdentifierValue)

        if (clinic == null) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + clinicIdentifierValue)
        }

        lookupAndSyncWithExternalProviders(clinic)

        return findAllPractitionersAssignedToClinic(clinic)
    }

    List<Practitioner> findAllPractitionersAssignedToClinic(Clinic clinic) {
        assignmentRepository.findByClinicId(clinic.pk)*.practitioner
    }

    void lookupAndSyncWithExternalProviders(Clinic clinic) {

        ((Facility) clinic).getIdentifierSystems().each { identifierSystem ->

            String clinicIdentifierValue = ((Facility) clinic).getIdentifierValue(identifierSystem)
            switch (identifierSystem) {
                case "http://prehmis.capetown.gov.za":
                    prehmisPractitionerApplicationService.lookupAndSynchronise(clinicIdentifierValue)
                    break
                default:
                    break
            }
        }
    }
}
