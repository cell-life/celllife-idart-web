package org.celllife.idart.client.good;

import org.celllife.idart.client.common.Identifier;
import org.celllife.idart.client.part.Drug;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class Medication implements Serializable {

    public Set<Identifier> identifiers = new HashSet<Identifier>();

    public Drug drug;

    public Medication() {
    }
}
