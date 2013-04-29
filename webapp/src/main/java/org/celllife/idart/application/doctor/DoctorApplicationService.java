package org.celllife.idart.application.doctor;

import org.celllife.idart.domain.doctor.Doctor;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 12h16
 */
public interface DoctorApplicationService {

    List<Doctor> findByClinicIdentifier(String applicationId, String clinicIdentifierValue);
}
