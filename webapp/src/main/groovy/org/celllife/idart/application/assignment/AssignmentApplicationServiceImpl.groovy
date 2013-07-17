package org.celllife.idart.application.assignment

import org.celllife.idart.domain.assignment.Assignment
import org.celllife.idart.domain.assignment.AssignmentRepository
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicRepository
import org.celllife.idart.domain.practitioner.Practitioner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 19h19
 */
@Service class AssignmentApplicationServiceImpl implements AssignmentApplicationService {

    @Autowired ClinicRepository clinicRepository

    @Autowired AssignmentRepository assignmentRepository

    Assignment assignPractitionerToClinic(Practitioner practitioner, Clinic clinic) {

        Assignment assignment = assignmentRepository.findOneByPractitionerPkAndClinicPk(practitioner.pk, clinic.pk)
        if (assignment == null) {
            assignment = assignmentRepository.save(new Assignment(practitioner: practitioner, clinic: clinic))
        }

        assignment
    }

}
