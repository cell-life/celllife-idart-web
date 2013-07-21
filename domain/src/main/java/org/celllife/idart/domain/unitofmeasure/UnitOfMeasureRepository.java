package org.celllife.idart.domain.unitofmeasure;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureRepository {

    UnitOfMeasure findOneByCode(String system, String code);

}
