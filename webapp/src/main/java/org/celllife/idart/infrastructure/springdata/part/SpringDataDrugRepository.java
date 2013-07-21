package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.Drug;
import org.celllife.idart.domain.part.DrugRepository;

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
@RestResource(path = "drugs")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDrugRepository extends PagingAndSortingRepository<Drug, Long>, DrugRepository{

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
