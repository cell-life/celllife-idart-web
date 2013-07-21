package org.celllife.idart.application.unitofmeasure;

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureResourceService {

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure);

    UnitOfMeasure findByCode(String code);

    Iterable<UnitOfMeasure> findAll();

}