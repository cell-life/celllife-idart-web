package org.celllife.idart.domain.practitioner;

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
@RestResource(path = "practitioners")
public interface PractitionerRepository extends PagingAndSortingRepository<Practitioner, Long> {

    @Query("select practitioner " +
            "from Practitioner practitioner " +
            "join practitioner.identifiers practitionerIdentifier " +
            "left join practitioner.person person " +
            "left join person.identifiers personIdentifier " +
            "where practitionerIdentifier.value = :identifierValue " +
            "or personIdentifier.value = :identifierValue")
    List<Practitioner> findByIdentifier(@Param("identifierValue") String identifierValue);

    @Query("select practitioner " +
            "from Practitioner practitioner " +
            "join practitioner.identifiers practitionerIdentifier " +
            "left join practitioner.person person " +
            "left join person.identifiers personIdentifier " +
            "where (practitionerIdentifier.system = :identifierSystem and practitionerIdentifier.value = :identifierValue) " +
            "or (personIdentifier.system = :identifierSystem and personIdentifier.value = :identifierValue)")
    Practitioner findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                     @Param("identifierValue") String identifierValue);

}
