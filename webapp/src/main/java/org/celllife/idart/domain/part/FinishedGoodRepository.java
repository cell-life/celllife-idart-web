package org.celllife.idart.domain.part;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 21h34
 */
@RestResource(path = "finishedGoods")
public interface FinishedGoodRepository extends PagingAndSortingRepository<FinishedGood, Long> {

    @Query("select finishedGood " +
            "from FinishedGood finishedGood " +
            "join finishedGood.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    FinishedGood findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                     @Param("identifierValue") String identifierValue);

}
