package org.celllife.idart.infrastructure.springdata.person;

import org.celllife.idart.domain.person.Person;
import org.celllife.idart.domain.person.PersonRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPersonRepository extends PagingAndSortingRepository<Person, Long>, PersonRepository {

    @Query("select person " +
            "from Person person " +
            "join person.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Person findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct person " +
            "from Person person " +
            "join person.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Person> findByIdentifier(@Param("identifierValue") String identifierValue);

}
