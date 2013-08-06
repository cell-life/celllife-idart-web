package org.celllife.idart.infrastructure.springdata.encounter;

import org.celllife.idart.domain.encounter.Encounter;
import org.celllife.idart.domain.encounter.EncounterRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataEncounterRepository extends PagingAndSortingRepository<Encounter, Long>, EncounterRepository {

    @Query("select encounter " +
            "from Encounter encounter " +
            "join encounter.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Encounter findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct encounter " +
            "from Encounter encounter " +
            "join encounter.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Encounter> findByIdentifier(@Param("identifierValue") String identifierValue);

}
