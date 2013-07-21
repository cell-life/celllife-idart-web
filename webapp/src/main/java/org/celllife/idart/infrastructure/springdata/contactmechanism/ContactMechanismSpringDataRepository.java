package org.celllife.idart.domain.contactmechanism;

import org.celllife.idart.domain.clinic.Clinic;
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
@RestResource(path = "contactMechanisms")
public interface ContactMechanismSpringDataRepository extends ContactMechanismRepository,  CrudRepository<ContactMechanism, Long> {

    @Query("select clinic " +
            "from Clinic clinic " +
            "join clinic.identifiers clinicIdentifier " +
            "where clinicIdentifier.value = :identifierValue")
    List<Clinic> findByIdentifier(@Param("identifierValue") String identifierValue);

    @Query("select clinic " +
            "from Clinic clinic  " +
            "join clinic.identifiers clinicIdentifier " +
            "where clinicIdentifier.system = :identifierSystem  " +
            "and clinicIdentifier.value = :identifierValue")
    Clinic findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                               @Param("identifierValue") String identifierValue);
}
