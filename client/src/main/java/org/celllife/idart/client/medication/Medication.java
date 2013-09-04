package org.celllife.idart.client.medication;

import org.celllife.idart.client.common.Id;
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

    public Set<Id> ids = new HashSet<Id>();

    public String name;

    public Drug drug;

    public Medication() {
    }
}
