package org.celllife.idart.client.unitofmeasure;

import org.celllife.idart.common.UnitOfMeasureCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 12h24
 */
public final class UnitOfMeasure implements Serializable {

    public UnitOfMeasureCode code;

    public String name;

    public String description;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(UnitOfMeasureCode code) {
        this.code = code;
    }
}
