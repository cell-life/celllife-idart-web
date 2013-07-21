package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.FinishedGood;
import org.celllife.idart.domain.part.FinishedGoodRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@RestResource(path = "finishedGoods")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataFinishedGoodRepository extends PagingAndSortingRepository<FinishedGood, Long>, FinishedGoodRepository{

    @Query("select finishedGood " +
            "from FinishedGood finishedGood " +
            "join finishedGood.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    FinishedGood findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct finishedGood " +
            "from FinishedGood finishedGood " +
            "join finishedGood.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<FinishedGood> findByIdentifier(@Param("identifierValue") String identifierValue);
}