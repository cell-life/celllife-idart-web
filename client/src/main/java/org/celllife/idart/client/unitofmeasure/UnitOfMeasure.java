package org.celllife.idart.client.unitofmeasure;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.LocalisedText;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 12h24
 */
public final class UnitOfMeasure implements Serializable {

    public Set<Code> codes = new HashSet<Code>();

    public Set<LocalisedText> names;

    public Set<LocalisedText> descriptions;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(String codeValue) {
        codes.add(new Code(codeValue));
    }
}
