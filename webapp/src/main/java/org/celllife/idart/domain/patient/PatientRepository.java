package org.celllife.idart.domain.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h56
 */
@RestResource(path = "patients")
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("select patient " +
            "from Patient patient " +
            "join patient.identifiers identifiers " +
            "where identifiers.value = :identifier")
    List<Patient> findByIdentifier(@Param("identifier") String identifier);


    @Query("select patient " +
            "from Patient patient " +
            "join patient.identifiers identifiers " +
            "where identifiers.value = :identifierValue " +
            "and identifiers.type = :identifierType")
    Patient findOneByIdentifier(@Param("identifierValue") String identifierValue,
                                @Param("identifierType") String identifierType);
}
