package org.celllife.idart.client.indication;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.LocalisedText;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class Indication implements Serializable {

    public Set<Code> codes;

    public Set<LocalisedText> names;

    public Set<LocalisedText> descriptions;

    public Indication() {
    }
}
