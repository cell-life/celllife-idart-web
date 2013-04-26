package org.celllife.idart.domain.patient;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
public interface PatientService {

    Iterable<Patient> save(Iterable<Patient> patients);

}
