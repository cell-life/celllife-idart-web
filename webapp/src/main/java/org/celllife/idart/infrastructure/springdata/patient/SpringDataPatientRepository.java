package org.celllife.idart.infrastructure.springdata.patient;

import org.celllife.idart.common.PatientId;
import org.celllife.idart.common.PersonId;
import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.domain.patient.PatientRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 */
public interface SpringDataPatientRepository extends PatientRepository, PagingAndSortingRepository<Patient, PatientId> {

    @Query("select patient.person from Patient patient where patient.id = :patientId")
    PersonId findPersonByPatientId(@Param("patientId") PatientId patientId);

}

