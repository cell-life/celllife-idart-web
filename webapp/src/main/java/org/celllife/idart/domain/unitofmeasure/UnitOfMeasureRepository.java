package org.celllife.idart.domain.unitofmeasure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 17h50
 */
public interface UnitOfMeasureRepository extends PagingAndSortingRepository<UnitOfMeasure, Long> {

    @Query("select unitOfMeasure " +
            "from UnitOfMeasure unitOfMeasure " +
            "join unitOfMeasure.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    UnitOfMeasure findOneBySystemAndCode(@Param("system") String system, @Param("code") String code);

}
