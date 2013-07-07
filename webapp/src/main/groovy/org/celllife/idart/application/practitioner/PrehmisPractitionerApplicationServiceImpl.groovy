package org.celllife.idart.application.practitioner

import org.celllife.idart.domain.assignment.Assignment
import org.celllife.idart.domain.assignment.AssignmentRepository
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicRepository
import org.celllife.idart.domain.partyrole.PartyRole
import org.celllife.idart.domain.person.PersonRepository
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-07
 * Time: 19h50
 */
@Service class PrehmisPractitionerApplicationServiceImpl implements PrehmisPractitionerApplicationService {

    @Autowired ClinicRepository clinicRepository

    @Autowired PractitionerCodeApplicationService practitionerCodeApplicationService

    @Autowired PractitionerProvider prehmisPractitionerProvider

    @Autowired PractitionerService practitionerService

    @Autowired PersonRepository personRepository

    @Autowired AssignmentRepository assignmentRepository

    void lookupAndSynchronise(String clinicIdentifierValue) {

        Clinic clinic = clinicRepository.findOneByIdentifier("http://prehmis.capetown.gov.za", clinicIdentifierValue)

        Set<Practitioner> prehmisPractitioners = prehmisPractitionerProvider.findAll(clinicIdentifierValue)
        Set<Practitioner> savedPractitioners = savePractitioners(prehmisPractitioners)
        assignPractitionersToClinic(savedPractitioners, clinic)
    }

    void assignPractitionersToClinic(Set<Practitioner> practitioners, Clinic clinic) {
        practitioners.each { practitioner ->
            Assignment assignment = assignmentRepository.findOneByPractitionerPkAndClinicPk(practitioner.pk, clinic.pk)
            if (assignment == null) {
                assignmentRepository.save(new Assignment(practitioner: practitioner, clinic: clinic))
            }
        }
    }

    Set<Practitioner> savePractitioners(Iterable<Practitioner> practitioners) {
        practitioners.collect { newPractitioner -> savePractitioner(newPractitioner) }
    }

    Practitioner savePractitioner(Practitioner newPractitioner) {

        personRepository.save(newPractitioner.person)

        def idartPractitionerIdentifierSystem = "http://www.cell-life.org/idart/practitioner"

        if (((PartyRole) newPractitioner).hasNoIdentifierForSystem(idartPractitionerIdentifierSystem)) {
            def code = practitionerCodeApplicationService.nextPractitionerCode()
            ((PartyRole) newPractitioner).addIdentifier(idartPractitionerIdentifierSystem, code)
        }

        practitionerService.save(newPractitioner)
    }
}
