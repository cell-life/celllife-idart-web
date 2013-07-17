package org.celllife.idart.application.assignment

import org.celllife.idart.domain.assignment.Assignment
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.practitioner.Practitioner

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-17
 * Time: 19h19
 */
interface AssignmentApplicationService {

    Assignment assignPractitionerToClinic(Practitioner practitioner, Clinic clinic)

}
