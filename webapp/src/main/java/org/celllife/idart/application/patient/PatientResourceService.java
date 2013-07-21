package org.celllife.idart.application.patient;

import org.celllife.idart.domain.patient.Patient;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientResourceService {

    Patient save(Patient patient);

    Patient findByIdentifier(String identifier);

    Iterable<Patient> findAll();

}