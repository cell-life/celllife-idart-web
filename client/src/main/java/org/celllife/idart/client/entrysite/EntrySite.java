package org.celllife.idart.client.entrysite;

import org.celllife.idart.common.EntrySiteCode;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class EntrySite implements Serializable {

    public EntrySiteCode code;

    public String name;

    public String description;

    public EntrySite() {
    }
}
