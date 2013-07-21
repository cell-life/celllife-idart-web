package org.celllife.idart.domain.unitofmeasure;

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
@RestResource(path = "unitsOfMeasure")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureRepository extends PagingAndSortingRepository<UnitOfMeasure, Long> {

    @Query("select unitOfMeasure " +
            "from UnitOfMeasure unitOfMeasure " +
            "join unitOfMeasure.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    UnitOfMeasure findOneByCode(@Param("system") String system, @Param("code") String code);

}
