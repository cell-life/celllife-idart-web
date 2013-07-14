package org.celllife.idart.domain.unitofmeasure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 17h50
 */
public interface UnitOfMeasureTypeRepository extends PagingAndSortingRepository<UnitOfMeasureType, Long> {

    @Query("select unitOfMeasureType " +
            "from UnitOfMeasureType unitOfMeasureType " +
            "join unitOfMeasureType.names name " +
            "where name.locale = :locale " +
            "and name.value = :value")
    UnitOfMeasureType findOneByName(@Param("locale") String locale, @Param("value") String value);
}
