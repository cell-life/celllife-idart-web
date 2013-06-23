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
            "join patient.identifiers patientIdentifiers " +
            "join patientIdentifiers.identifiers patientIdentifiersIdentifier " +
            "join patient.person.identifiers personIdentifiers " +
            "join personIdentifiers.identifiers personIdentifiersIdentifier " +
            "where patientIdentifiersIdentifier.value = :identifierValue " +
            "or personIdentifiersIdentifier.value = :identifierValue")
    List<Patient> findByIdentifier(@Param("identifierValue") String identifierValue);


    @Query("select patient " +
            "from Patient patient " +
            "join patient.identifiers patientIdentifiers " +
            "join patientIdentifiers.identifiers patientIdentifiersIdentifier " +
            "join patient.person.identifiers personIdentifiers " +
            "join personIdentifiers.identifiers personIdentifiersIdentifier " +
            "where (patientIdentifiersIdentifier.system = :identifierSystem and patientIdentifiersIdentifier.value = :identifierValue) " +
            "or (personIdentifiersIdentifier.system = :identifierSystem and personIdentifiersIdentifier.value = :identifierValue)")
    Patient findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                @Param("identifierValue") String identifierValue);

}
