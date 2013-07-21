package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.Part;
import org.celllife.idart.domain.part.PartRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@RestResource(path = "parts")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataPartRepository extends PagingAndSortingRepository<Part, Long>, PartRepository{

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
