package org.celllife.idart.domain.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 11h32
 */
@RestResource(path = "goods")
public interface GoodRepository extends PagingAndSortingRepository<Good, Long> {

    @Query("select good " +
            "from Good good " +
            "join good.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Good findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                             @Param("identifierValue") String identifierValue);

}
