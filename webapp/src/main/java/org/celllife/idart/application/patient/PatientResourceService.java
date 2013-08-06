package org.celllife.idart.application.patient;

import org.celllife.idart.domain.patient.Patient;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientResourceService {

    Patient save(Patient patient);

    Patient findByIdentifier(String identifier);

    Iterable<Patient> findAll();

}