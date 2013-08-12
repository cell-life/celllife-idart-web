package org.celllife.idart.infrastructure.springdata.patient;

import org.celllife.idart.common.PatientIdentifier;
import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.domain.patient.PatientRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPatientRepository extends PatientRepository,
        PagingAndSortingRepository<Patient, PatientIdentifier> {

}