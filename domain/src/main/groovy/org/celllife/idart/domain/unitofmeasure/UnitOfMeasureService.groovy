package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.domain.common.Code

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureService {

    Iterable<UnitOfMeasure> save(Iterable<UnitOfMeasure> unitsOfMeasure)

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

    Iterable<UnitOfMeasure> findAll()

    UnitOfMeasure findByCode(String code)

    UnitOfMeasure findByCodes(Iterable<Code> codes)

}