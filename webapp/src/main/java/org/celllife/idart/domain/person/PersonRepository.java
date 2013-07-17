package org.celllife.idart.domain.person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 12h47
 */
@RestResource(path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @Query("select person " +
            "from Person person " +
            "join person.identifiers personIdentifier " +
            "where personIdentifier.system = :identifierSystem and personIdentifier.value = :identifierValue")
    Person findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                               @Param("identifierValue") String identifierValue);

}
