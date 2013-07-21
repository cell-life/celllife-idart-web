package org.celllife.idart.domain.unitofmeasure;

import org.springframework.data.repository.CrudRepository;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h19
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureSpringDataRepository extends CrudRepository<UnitOfMeasure, Long> {

    UnitOfMeasure findOneByCode(String system, String code);

}
