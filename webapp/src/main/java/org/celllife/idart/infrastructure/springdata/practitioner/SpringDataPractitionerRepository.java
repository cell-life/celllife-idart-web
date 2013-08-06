package org.celllife.idart.infrastructure.springdata.practitioner;

import org.celllife.idart.domain.practitioner.Practitioner;
import org.celllife.idart.domain.practitioner.PractitionerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
public interface SpringDataPractitionerRepository extends PractitionerRepository, PagingAndSortingRepository<Practitioner, Long> {

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
