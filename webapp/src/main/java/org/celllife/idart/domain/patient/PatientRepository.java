package org.celllife.idart.domain.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
@RestResource(path = "patients")
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {

    @Query("select patient " +
            "from Patient patient " +
            "join patient.identifiers patientIdentifier " +
            "join patient.person.identifiers personIdentifier " +
            "where patientIdentifier.value = :identifierValue " +
            "or personIdentifier.value = :identifierValue")
    List<Patient> findByIdentifier(@Param("identifierValue") String identifierValue);


    @Query("select patient " +
            "from Patient patient " +
            "join patient.identifiers patientIdentifier " +
            "join patient.person.identifiers personIdentifier " +
            "where (patientIdentifier.system = :identifierSystem and patientIdentifier.value = :identifierValue) " +
            "or (personIdentifier.system = :identifierSystem and personIdentifier.value = :identifierValue)")
    Patient findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                @Param("identifierValue") String identifierValue);

}
