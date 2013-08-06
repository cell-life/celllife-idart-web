package org.celllife.idart.infrastructure.springdata.unitofmeasure;

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureCode;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataUnitOfMeasureRepository extends PagingAndSortingRepository<UnitOfMeasure, UnitOfMeasureCode>, UnitOfMeasureRepository {

}
