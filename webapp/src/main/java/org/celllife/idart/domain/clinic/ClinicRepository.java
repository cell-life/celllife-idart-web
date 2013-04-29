package org.celllife.idart.domain.clinic;

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
@RestResource(path = "clinics")
public interface ClinicRepository extends CrudRepository<Clinic, Long> {

    @Query("select clinic " +
            "from Clinic clinic " +
            "join clinic.identifiers identifiers " +
            "where identifiers.value = :identifier"
    )
    List<Clinic> findByIdentifier(@Param("identifier") String identifier);

    @Query("select clinic " +
            "from Clinic clinic " +
            "join clinic.identifiers identifiers " +
            "where identifiers.value = :identifierValue " +
            "and identifiers.type = :identifierType")
    Clinic findOneByIdentifier(@Param("identifierValue") String identifierValue,
                               @Param("identifierType") ClinicIdentifierType identifierType);
}
