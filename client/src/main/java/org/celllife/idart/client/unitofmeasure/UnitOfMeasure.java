package org.celllife.idart.client.unitofmeasure;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.LocalizedText;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 12h24
 */
public final class UnitOfMeasure implements Serializable {

    public Set<Code> codes;

    public Set<LocalizedText> names;

    public Set<LocalizedText> descriptions;

    public UnitOfMeasure() {
    }
}
