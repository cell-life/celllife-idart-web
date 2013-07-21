package org.celllife.idart.domain.product;

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
@RestResource(path = "goods")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface GoodRepository extends PagingAndSortingRepository<Good, Long> {

    @Query("select good " +
            "from Good good " +
            "join good.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Good findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct good " +
            "from Good good " +
            "join good.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Good> findByIdentifier(@Param("identifierValue") String identifierValue);
}
