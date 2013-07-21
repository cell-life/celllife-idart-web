package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.DrugGroup;
import org.celllife.idart.domain.part.DrugGroupRepository;

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
@RestResource(path = "drugGroups")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDrugGroupRepository extends PagingAndSortingRepository<DrugGroup, Long>, DrugGroupRepository{

    @Query("select drugGroup " +
            "from DrugGroup drugGroup " +
            "join drugGroup.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    DrugGroup findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct drugGroup " +
            "from DrugGroup drugGroup " +
            "join drugGroup.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<DrugGroup> findByIdentifier(@Param("identifierValue") String identifierValue);
}
