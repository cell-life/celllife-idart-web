package org.celllife.idart.client.indication;

import org.celllife.idart.common.IndicationCode;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class Indication implements Serializable {

    public IndicationCode code;

    public String name;

    public String description;

    public Indication() {
    }
}
