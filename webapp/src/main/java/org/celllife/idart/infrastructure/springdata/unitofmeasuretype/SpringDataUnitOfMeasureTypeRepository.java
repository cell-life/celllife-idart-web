package org.celllife.idart.infrastructure.springdata.unitofmeasuretype;

import org.celllife.idart.common.UnitOfMeasureTypeCode;
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType;
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataUnitOfMeasureTypeRepository extends UnitOfMeasureTypeRepository,
        PagingAndSortingRepository<UnitOfMeasureType, UnitOfMeasureTypeCode> {

}