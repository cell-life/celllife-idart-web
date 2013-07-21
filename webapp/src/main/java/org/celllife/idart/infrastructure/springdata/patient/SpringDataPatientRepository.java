package org.celllife.idart.infrastructure.springdata.patient;

import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.domain.patient.PatientRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
@RestResource(path = "patients")
public interface SpringDataPatientRepository extends PatientRepository, PagingAndSortingRepository<Patient, Long> {

    @Query("select distinct patient " +
            "from Patient patient " +
            "join patient.identifiers patientIdentifier " +
            "left join patient.person person " +
            "left join person.identifiers personIdentifier " +
            "where (patientIdentifier.system = :identifierSystem and patientIdentifier.value = :identifierValue) " +
            "or (personIdentifier.system = :identifierSystem and personIdentifier.value = :identifierValue)")
    Patient findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                @Param("identifierValue") String identifierValue);

}
