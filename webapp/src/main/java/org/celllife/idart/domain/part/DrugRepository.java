package org.celllife.idart.domain.part;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@RestResource(path = "drugs")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugRepository extends PagingAndSortingRepository<Drug, Long> {

    @Query("select drug " +
            "from Drug drug " +
            "join drug.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Drug findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct drug " +
            "from Drug drug " +
            "join drug.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Drug> findByIdentifier(@Param("identifierValue") String identifierValue);
}