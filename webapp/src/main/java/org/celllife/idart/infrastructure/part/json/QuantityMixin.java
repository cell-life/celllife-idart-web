package org.celllife.idart.infrastructure.part.json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.framework.json.CodeableSerializer;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */
public interface QuantityMixin {

    @JsonSerialize(using = CodeableSerializer.class)
    UnitOfMeasure getUnitOfMeasure();

}
