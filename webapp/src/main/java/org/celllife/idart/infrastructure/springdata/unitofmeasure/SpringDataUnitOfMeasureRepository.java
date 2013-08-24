package org.celllife.idart.infrastructure.springdata.unitofmeasure;

import org.celllife.idart.common.UnitOfMeasureCode;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataUnitOfMeasureRepository extends UnitOfMeasureRepository,
        PagingAndSortingRepository<UnitOfMeasure, UnitOfMeasureCode> {

}
