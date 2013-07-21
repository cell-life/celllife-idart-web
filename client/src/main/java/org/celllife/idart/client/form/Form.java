package org.celllife.idart.client.form;

import org.celllife.idart.client.common.Code;
import org.celllife.idart.client.common.LocalizedText;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 12h24
 */
public final class Form implements Serializable {

    public Set<Code> codes;

    public Set<LocalizedText> names;

    public Set<LocalizedText> descriptions;

    public Form() {
    }
}
