package org.celllife.idart.domain.doctor;

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
@RestResource(path = "doctors")
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Query("select doctor " +
            "from Doctor doctor " +
            "join doctor.identifiers identifiers " +
            "where identifiers.value = :identifier"
    )
    List<Doctor> findByIdentifier(@Param("identifier") String identifier);

    @Query("select doctor " +
            "from Doctor doctor " +
            "join doctor.identifiers identifiers " +
            "where identifiers.value = :identifierValue " +
            "and identifiers.type = :identifierType")
    Doctor findOneByIdentifier(@Param("identifierValue") String identifierValue,
                               @Param("identifierType") DoctorIdentifierType identifierType);

}
