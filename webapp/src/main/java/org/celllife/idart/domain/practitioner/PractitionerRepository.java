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
            "join practitioner.identifiers identifier " +
            "where identifier.value = :identifier")
    List<Practitioner> findByIdentifier(@Param("identifier") String identifier);

    @Query("select practitioner " +
            "from Practitioner practitioner " +
            "join practitioner.identifiers identifier " +
            "where identifier.value = :identifierValue " +
            "and identifier.system = :identifierSystem")
    Practitioner findOneByIdentifier(@Param("identifierValue") String identifierValue,
                                     @Param("identifierSystem") String identifierSystem);

}
