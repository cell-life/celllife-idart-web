package org.celllife.idart.client.medication;

import org.celllife.idart.client.part.Drug;
import org.celllife.idart.common.Identifier;

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

    public String name;

    public Drug drug;

    public Medication() {
    }
}
