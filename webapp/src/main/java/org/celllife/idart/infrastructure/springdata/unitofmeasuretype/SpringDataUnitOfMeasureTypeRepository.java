package org.celllife.idart.infrastructure.springdata.unitofmeasuretype;

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType;
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeCode;
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataUnitOfMeasureTypeRepository extends PagingAndSortingRepository<UnitOfMeasureType, UnitOfMeasureTypeCode>, UnitOfMeasureTypeRepository {

}
