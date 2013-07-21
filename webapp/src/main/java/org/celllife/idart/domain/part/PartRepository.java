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
@RestResource(path = "parts")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartRepository extends PagingAndSortingRepository<Part, Long> {

    @Query("select part " +
            "from Part part " +
            "join part.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Part findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct part " +
            "from Part part " +
            "join part.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Part> findByIdentifier(@Param("identifierValue") String identifierValue);
}
