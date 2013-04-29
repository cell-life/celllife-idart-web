package org.celllife.idart.application.doctor;

import org.celllife.idart.domain.doctor.Doctor;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h02
 */
public interface DoctorProvider {

    Set<Doctor> findAll(String clinicIdentifierValue);
}
